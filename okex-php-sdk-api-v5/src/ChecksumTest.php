<?php
/**
 * Created by PhpStorm.
 * User: hengliu
 * Date: 2019/7/20
 * Time: 11:07 PM
 */

namespace okv5;

class ChecksumTest{
    /**
     * 校验和
     * @param $partial
     * @return bool
     */
    function checksum($partial){

        $partial = json_decode($partial, true);

        $asks = array_values($partial["data"][0]["asks"]);

        $bids = array_values($partial["data"][0]["bids"]);

        $strs="";
        for ($i=0; $i<25; $i++){
            if (@$bids[$i]){
                $strs.=$bids[$i][0];
                $strs.=":";
                $strs.=$bids[$i][1];
                $strs.=":";
            }

            if (@$asks[$i]){
                $strs.=$asks[$i][0];
                $strs.=":";
                $strs.=$asks[$i][1];
                $strs.=":";
            }
        }

        $strs = substr($strs,0,strlen($strs)-1);

        print_r($strs . "\n");

        $strs = crc32($strs);

        // 计算前25档的checksum
        $strs = $this->get_signed_int($strs);

        switch (true)
        {
            case ($partial["data"][0]["checksum"]==$strs);
                return true;
                break;
            default:
                return false;
                break;
        }
//        print_r("\nchecksum:".$strs);
    }

    /**
     * 深度合并
     * @param $partial
     * @param $update
     * @return false|string
     */
    function depthMerge($partial, $update){

        $partial = json_decode($partial,true);
        $update = json_decode($update,true);

        $ndata = $partial;

        $partialAsks = $partial["data"][0]["asks"];
        $partialBids = $partial["data"][0]["bids"];
        $updateAsks = $update["data"][0]["asks"];
        $updateBids = $update["data"][0]["bids"];

        if (!empty($updateAsks)){

            for ($i=0; $i<count($partialAsks); $i++){
                for($j=0; $j<count($updateAsks); $j++){
                    switch (true){
                        // 如果价格相同
                        case ($updateAsks[$j][0]==$partialAsks[$i][0]);
                            switch (true){
                                // 数量为0删除此深度，数量有变化则替换此数据
                                case ($updateAsks[$j][1] == 0);
                                    unset($ndata["data"][0]["asks"][$i]);
                                    break;
                                // 同价格，不同数量，替换
                                case ($updateAsks[$j][1] != $partialAsks[$i][1]);
                                    $ndata["data"][0]["asks"][$i][1] = $updateAsks[$j][1];
                                    break;
                            }
                            break;
                        // 如何价格不同
                        case (!$this->deep_in_array($updateAsks[$j][0],$ndata["data"][0]["asks"]) and $updateAsks[$j][1] != 0);
                            array_push($ndata["data"][0]["asks"], $updateAsks[$j]);
                            break;
                    }
                }
            }
        }

        if (!empty($updateBids)){

            for ($i=0; $i<count($partialBids); $i++){
                for($j=0; $j<count($updateBids); $j++){
                    switch (true){
                        // 如果价格相同
                        case ($updateBids[$j][0] == $partialBids[$i][0]);
                            switch (true){
                                case ($updateBids[$j][1] ==0);
                                    unset($ndata["data"][0]["bids"][$i]);
                                    break;
                                case ($updateBids[$j][1] != $partialBids[$i][1]);
                                    $ndata["data"][0]["bids"][$i][1] = $updateBids[$j][1];
                                    break;
                            }
                            break;

                        // 如果 价格不同
                        case (!$this->deep_in_array($updateBids[$j][0], $ndata["data"][0]["bids"]) and $updateBids[$j][1] != 0);
                            array_push($ndata["data"][0]["bids"], $updateBids[$j]);
                            break;
                    }
                }
            }
        }

        // asks 从小到大排序
        $askPrices = array_column($ndata["data"][0]["asks"],0);
        array_multisort($askPrices,SORT_ASC,$ndata["data"][0]["asks"]);

        // bids 从大到小排序
        $bidPrices = array_column($ndata["data"][0]["bids"],0);
        array_multisort($bidPrices,SORT_DESC,$ndata["data"][0]["bids"]);

        // 换 checksum
        $ndata["data"][0]["checksum"] = $update["data"][0]["checksum"];

//        print_r(json_encode($ndata));
        return json_encode($ndata);
    }

    /**
     * 获取32位校验码
     * @param $in
     * @return float|int
     */
    protected function get_signed_int($in) {
        $int_max = pow(2, 31)-1;
        if ($in > $int_max){
            $out = $in - $int_max * 2 - 2;
        }
        else {
            $out = $in;
        }
        return $out;
    }

    /**
     * // 数组的深度搜索
     * @param $value
     * @param $array
     * @return bool
     */
    protected function deep_in_array($value, $array) {
        foreach($array as $item) {
            if (!is_array($item)) {
                if ($item == $value) {
                    return true;
                } else {
                    continue;
                }
            }

            if (in_array($value, $item)) {
                return true;
            } else if ($this->deep_in_array($value, $item)) {
                return true;
            }
        }

        return false;
    }

    public function getCrc32($strs){

        $strs = crc32($strs);

        // 计算前25档的checksum
        $strs = $this->get_signed_int($strs);

        print_r($strs);
        print_r("\n");
    }
}
