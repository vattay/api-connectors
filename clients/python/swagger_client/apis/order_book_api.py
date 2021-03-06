# coding: utf-8

"""
    BitMEX API

    ## REST API for the BitMEX Trading Platform  [Changelog](/app/apiChangelog)  ----  #### Getting Started   ##### Fetching Data  All REST endpoints are documented below. You can try out any query right from this interface.  Most table queries accept `count`, `start`, and `reverse` params. Set `reverse=true` to get rows newest-first.  Additional documentation regarding filters, timestamps, and authentication is available in [the main API documentation](https://www.bitmex.com/app/restAPI).  *All* table data is available via the [Websocket](/app/wsAPI). We highly recommend using the socket if you want to have the quickest possible data without being subject to ratelimits.  ##### Return Types  By default, all data is returned as JSON. Send `?_format=csv` to get CSV data or `?_format=xml` to get XML data.  ##### Trade Data Queries  *This is only a small subset of what is available, to get you started.*  Fill in the parameters and click the `Try it out!` button to try any of these queries.  * [Pricing Data](#!/Quote/Quote_get)  * [Trade Data](#!/Trade/Trade_get)  * [OrderBook Data](#!/OrderBook/OrderBook_getL2)  * [Settlement Data](#!/Settlement/Settlement_get)  * [Exchange Statistics](#!/Stats/Stats_history)  Every function of the BitMEX.com platform is exposed here and documented. Many more functions are available.  ---  ## All API Endpoints  Click to expand a section. 

    OpenAPI spec version: 1.2.0
    Contact: support@bitmex.com
    Generated by: https://github.com/swagger-api/swagger-codegen.git

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
"""

from __future__ import absolute_import

import sys
import os
import re

# python 2 and python 3 compatibility library
from six import iteritems

from ..configuration import Configuration
from ..api_client import ApiClient


class OrderBookApi(object):
    """
    NOTE: This class is auto generated by the swagger code generator program.
    Do not edit the class manually.
    Ref: https://github.com/swagger-api/swagger-codegen
    """

    def __init__(self, api_client=None):
        config = Configuration()
        if api_client:
            self.api_client = api_client
        else:
            if not config.api_client:
                config.api_client = ApiClient()
            self.api_client = config.api_client

    def order_book_get(self, symbol, **kwargs):
        """
        Get current orderbook [deprecated, use /orderBook/L2].
        

        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.order_book_get(symbol, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str symbol: Instrument symbol. Send a series (e.g. XBT) to get data for the nearest contract in that series. (required)
        :param float depth: Orderbook depth.
        :return: list[OrderBook]
                 If the method is called asynchronously,
                 returns the request thread.
        """
        kwargs['_return_http_data_only'] = True
        if kwargs.get('callback'):
            return self.order_book_get_with_http_info(symbol, **kwargs)
        else:
            (data) = self.order_book_get_with_http_info(symbol, **kwargs)
            return data

    def order_book_get_with_http_info(self, symbol, **kwargs):
        """
        Get current orderbook [deprecated, use /orderBook/L2].
        

        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.order_book_get_with_http_info(symbol, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str symbol: Instrument symbol. Send a series (e.g. XBT) to get data for the nearest contract in that series. (required)
        :param float depth: Orderbook depth.
        :return: list[OrderBook]
                 If the method is called asynchronously,
                 returns the request thread.
        """

        all_params = ['symbol', 'depth']
        all_params.append('callback')
        all_params.append('_return_http_data_only')

        params = locals()
        for key, val in iteritems(params['kwargs']):
            if key not in all_params:
                raise TypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method order_book_get" % key
                )
            params[key] = val
        del params['kwargs']
        # verify the required parameter 'symbol' is set
        if ('symbol' not in params) or (params['symbol'] is None):
            raise ValueError("Missing the required parameter `symbol` when calling `order_book_get`")

        if 'depth' in params and params['depth'] < 0.0:
            raise ValueError("Invalid value for parameter `depth` when calling `order_book_get`, must be a value greater than or equal to `0.0`")
        resource_path = '/orderBook'.replace('{format}', 'json')
        path_params = {}

        query_params = {}
        if 'symbol' in params:
            query_params['symbol'] = params['symbol']
        if 'depth' in params:
            query_params['depth'] = params['depth']

        header_params = {}

        form_params = []
        local_var_files = {}

        body_params = None

        # HTTP header `Accept`
        header_params['Accept'] = self.api_client.\
            select_header_accept(['application/json', 'application/xml', 'text/xml', 'application/javascript', 'text/javascript'])
        if not header_params['Accept']:
            del header_params['Accept']

        # HTTP header `Content-Type`
        header_params['Content-Type'] = self.api_client.\
            select_header_content_type(['application/json', 'application/x-www-form-urlencoded'])

        # Authentication setting
        auth_settings = []

        return self.api_client.call_api(resource_path, 'GET',
                                            path_params,
                                            query_params,
                                            header_params,
                                            body=body_params,
                                            post_params=form_params,
                                            files=local_var_files,
                                            response_type='list[OrderBook]',
                                            auth_settings=auth_settings,
                                            callback=params.get('callback'),
                                            _return_http_data_only=params.get('_return_http_data_only'))

    def order_book_get_l2(self, symbol, **kwargs):
        """
        Get current orderbook in vertical format.
        

        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.order_book_get_l2(symbol, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str symbol: Instrument symbol. Send a series (e.g. XBT) to get data for the nearest contract in that series. (required)
        :param float depth: Orderbook depth per side. Send 0 for full depth.
        :return: list[OrderBookL2]
                 If the method is called asynchronously,
                 returns the request thread.
        """
        kwargs['_return_http_data_only'] = True
        if kwargs.get('callback'):
            return self.order_book_get_l2_with_http_info(symbol, **kwargs)
        else:
            (data) = self.order_book_get_l2_with_http_info(symbol, **kwargs)
            return data

    def order_book_get_l2_with_http_info(self, symbol, **kwargs):
        """
        Get current orderbook in vertical format.
        

        This method makes a synchronous HTTP request by default. To make an
        asynchronous HTTP request, please define a `callback` function
        to be invoked when receiving the response.
        >>> def callback_function(response):
        >>>     pprint(response)
        >>>
        >>> thread = api.order_book_get_l2_with_http_info(symbol, callback=callback_function)

        :param callback function: The callback function
            for asynchronous request. (optional)
        :param str symbol: Instrument symbol. Send a series (e.g. XBT) to get data for the nearest contract in that series. (required)
        :param float depth: Orderbook depth per side. Send 0 for full depth.
        :return: list[OrderBookL2]
                 If the method is called asynchronously,
                 returns the request thread.
        """

        all_params = ['symbol', 'depth']
        all_params.append('callback')
        all_params.append('_return_http_data_only')

        params = locals()
        for key, val in iteritems(params['kwargs']):
            if key not in all_params:
                raise TypeError(
                    "Got an unexpected keyword argument '%s'"
                    " to method order_book_get_l2" % key
                )
            params[key] = val
        del params['kwargs']
        # verify the required parameter 'symbol' is set
        if ('symbol' not in params) or (params['symbol'] is None):
            raise ValueError("Missing the required parameter `symbol` when calling `order_book_get_l2`")

        if 'depth' in params and params['depth'] < 0.0:
            raise ValueError("Invalid value for parameter `depth` when calling `order_book_get_l2`, must be a value greater than or equal to `0.0`")
        resource_path = '/orderBook/L2'.replace('{format}', 'json')
        path_params = {}

        query_params = {}
        if 'symbol' in params:
            query_params['symbol'] = params['symbol']
        if 'depth' in params:
            query_params['depth'] = params['depth']

        header_params = {}

        form_params = []
        local_var_files = {}

        body_params = None

        # HTTP header `Accept`
        header_params['Accept'] = self.api_client.\
            select_header_accept(['application/json', 'application/xml', 'text/xml', 'application/javascript', 'text/javascript'])
        if not header_params['Accept']:
            del header_params['Accept']

        # HTTP header `Content-Type`
        header_params['Content-Type'] = self.api_client.\
            select_header_content_type(['application/json', 'application/x-www-form-urlencoded'])

        # Authentication setting
        auth_settings = []

        return self.api_client.call_api(resource_path, 'GET',
                                            path_params,
                                            query_params,
                                            header_params,
                                            body=body_params,
                                            post_params=form_params,
                                            files=local_var_files,
                                            response_type='list[OrderBookL2]',
                                            auth_settings=auth_settings,
                                            callback=params.get('callback'),
                                            _return_http_data_only=params.get('_return_http_data_only'))
