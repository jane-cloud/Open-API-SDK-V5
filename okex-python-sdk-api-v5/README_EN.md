## How to use ?

`python version：3.6+`

`WebSocketAPI： websockets package advise version 6.0`

#### Step 1: Download the SDK and install the necessary libraries

1.1 Download python SDK 

- `Clone` or `Download` the SDK directory to your local directory,choose to use `okex-python-sdk-api-v5`

1.2 Install the necessary libraries

```python
pip install requests
pip install websockets==6.0
```

#### Step 2: Configure Personal Information

2.1 If you have no API，[Click here](https://www.okex.com/account/users/myApi) to the official websit to apply for the API

2.2 Fill out all necessary informatiuon in `example.py（RestAPI）`  and `websocket_example.py（WebSocketAPI）`

```python 
api_key = ""
secret_key = ""
passphrase = ""
```

#### Step 3: Call API 

- RestAPI
  - Run `example.py`
  - Uncomment the corresponding method and then pass the arguments and call the interfaces
- WebSocketAPI
  - Run `websocket_example.py`
  - According to the `public channel`/`private channel`/`trade`, select the corresponding `url`, the corresponding start method, and pass in the corresponding parameters

```python 
# WebSocket public channel
url = "wss://ws.okex.com:8443/ws/v5/public?brokerId=9999"

# WebSocket private channel
url = "wss://ws.okex.com:8443/ws/v5/private?brokerId=9999"
```

```Python
# Not necessary for public channel to login （Instrument, Tickers, Index, Mark price, Order Book, Funding rate, etc）
loop.run_until_complete(subscribe_without_login(url, channels))

# necessary for private channel to login（Account,Positions, Order, etc）
loop.run_until_complete(subscribe(url, api_key, passphrase, seceret_key, channels))

# trade（Place Order, Cancel Order, Amend Order, etc）
loop.run_until_complete(trade(url, api_key, passphrase, seceret_key, trade_param))
```

P.S. 

- If  you know little about API, advise consulting the  offical [API document](https://www.okex.com/docs-v5/en/)

- User with RestAPI can configure parameter `flag` in `example.py` in  to choose to access to real trading or demo trading 

- User with WebSocketAPI can ucomment the corresponding `url`  to choose to access to real trading or demo trading 

- If you face any questions when using `WebSocketAPI`,you can consult related link

  - `asyncio`、`websockets` document/`github`：

    ```python 
    https://docs.python.org/3/library/asyncio-dev.html
    https://websockets.readthedocs.io/en/stable/intro.html
    https://github.com/aaugustin/websockets
    ```

  - About `code=1006`：

    ```python 
    https://github.com/Rapptz/discord.py/issues/1996
    https://github.com/aaugustin/websockets/issues/587
    ```

    

