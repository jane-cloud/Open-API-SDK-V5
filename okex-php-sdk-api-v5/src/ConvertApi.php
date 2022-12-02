<?php


namespace okv5;


class ConvertAPI extends Utils
{

    public function currencies(){
        $params = [
        ];

        return $this->request('/api/v5/asset/convert/currencies', $params, 'GET');
    }

    public function currencyPair($fromCc,$toCcy){
        $params = [
            'fromCcy' => $fromCcy,
            'toCcy' => $toCcy,
        ];

        return $this->request('/api/v5/asset/convert/currency-pair', $params, 'GET');
    }

    public function estimateQuote($baseCcy,$quoteCcy,$side,$rfqSz,$rfqSzCcy,$clQReqId='',$tag=''){
        $params = [
            'baseCcy' => $baseCcy,
            'quoteCcy' => $quoteCcy,
            'side' => $quotesideCcy,
            'rfqSz' => $rfqSz,
            'rfqSzCcy' => $rfqSzCcy,
            'clQReqId' => $clQReqId,
            'tag' => $tag,
        ];

        return $this->request('/api/v5/asset/convert/estimate-quote', $params, 'POST');
    }

    public function trade($quoteId,$baseCcy,$quoteCcy,$side,$sz,$szCcy,$clTReqId='',$tag=''){
        $params = [
            'quoteId' => $quoteId,
            'baseCcy' => $baseCcy,
            'quoteCcy' => $quoteCcy,
            'side' => $quotesideCcy,
            'sz' => $sz,
            'szCcy' => $szCcy,
            'clTReqId' => $clTReqId,
            'tag' => $tag,
        ];

        return $this->request('/api/v5/asset/convert/trade', $params, 'POST');
    }

    public function history($after='',$before='',$limit='',$tag=''){
        $params = [
            'after' => $after,
            'before' => $before,
            'limit' => $limit,
            'tag' => $tag,
        ];

        return $this->request('/api/v5/asset/convert/history', $params, 'GET');
    }

    
}
