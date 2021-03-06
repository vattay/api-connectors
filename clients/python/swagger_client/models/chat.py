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

from pprint import pformat
from six import iteritems
import re


class Chat(object):
    """
    NOTE: This class is auto generated by the swagger code generator program.
    Do not edit the class manually.
    """
    def __init__(self, id=None, date=None, user=None, message=None, html=None, from_bot=False, channel_id=None):
        """
        Chat - a model defined in Swagger

        :param dict swaggerTypes: The key is attribute name
                                  and the value is attribute type.
        :param dict attributeMap: The key is attribute name
                                  and the value is json key in definition.
        """
        self.swagger_types = {
            'id': 'float',
            'date': 'date',
            'user': 'str',
            'message': 'str',
            'html': 'str',
            'from_bot': 'bool',
            'channel_id': 'float'
        }

        self.attribute_map = {
            'id': 'id',
            'date': 'date',
            'user': 'user',
            'message': 'message',
            'html': 'html',
            'from_bot': 'fromBot',
            'channel_id': 'channelID'
        }

        self._id = id
        self._date = date
        self._user = user
        self._message = message
        self._html = html
        self._from_bot = from_bot
        self._channel_id = channel_id

    @property
    def id(self):
        """
        Gets the id of this Chat.


        :return: The id of this Chat.
        :rtype: float
        """
        return self._id

    @id.setter
    def id(self, id):
        """
        Sets the id of this Chat.


        :param id: The id of this Chat.
        :type: float
        """

        self._id = id

    @property
    def date(self):
        """
        Gets the date of this Chat.


        :return: The date of this Chat.
        :rtype: date
        """
        return self._date

    @date.setter
    def date(self, date):
        """
        Sets the date of this Chat.


        :param date: The date of this Chat.
        :type: date
        """

        self._date = date

    @property
    def user(self):
        """
        Gets the user of this Chat.


        :return: The user of this Chat.
        :rtype: str
        """
        return self._user

    @user.setter
    def user(self, user):
        """
        Sets the user of this Chat.


        :param user: The user of this Chat.
        :type: str
        """

        self._user = user

    @property
    def message(self):
        """
        Gets the message of this Chat.


        :return: The message of this Chat.
        :rtype: str
        """
        return self._message

    @message.setter
    def message(self, message):
        """
        Sets the message of this Chat.


        :param message: The message of this Chat.
        :type: str
        """

        self._message = message

    @property
    def html(self):
        """
        Gets the html of this Chat.


        :return: The html of this Chat.
        :rtype: str
        """
        return self._html

    @html.setter
    def html(self, html):
        """
        Sets the html of this Chat.


        :param html: The html of this Chat.
        :type: str
        """

        self._html = html

    @property
    def from_bot(self):
        """
        Gets the from_bot of this Chat.


        :return: The from_bot of this Chat.
        :rtype: bool
        """
        return self._from_bot

    @from_bot.setter
    def from_bot(self, from_bot):
        """
        Sets the from_bot of this Chat.


        :param from_bot: The from_bot of this Chat.
        :type: bool
        """

        self._from_bot = from_bot

    @property
    def channel_id(self):
        """
        Gets the channel_id of this Chat.


        :return: The channel_id of this Chat.
        :rtype: float
        """
        return self._channel_id

    @channel_id.setter
    def channel_id(self, channel_id):
        """
        Sets the channel_id of this Chat.


        :param channel_id: The channel_id of this Chat.
        :type: float
        """

        self._channel_id = channel_id

    def to_dict(self):
        """
        Returns the model properties as a dict
        """
        result = {}

        for attr, _ in iteritems(self.swagger_types):
            value = getattr(self, attr)
            if isinstance(value, list):
                result[attr] = list(map(
                    lambda x: x.to_dict() if hasattr(x, "to_dict") else x,
                    value
                ))
            elif hasattr(value, "to_dict"):
                result[attr] = value.to_dict()
            elif isinstance(value, dict):
                result[attr] = dict(map(
                    lambda item: (item[0], item[1].to_dict())
                    if hasattr(item[1], "to_dict") else item,
                    value.items()
                ))
            else:
                result[attr] = value

        return result

    def to_str(self):
        """
        Returns the string representation of the model
        """
        return pformat(self.to_dict())

    def __repr__(self):
        """
        For `print` and `pprint`
        """
        return self.to_str()

    def __eq__(self, other):
        """
        Returns true if both objects are equal
        """
        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """
        Returns true if both objects are not equal
        """
        return not self == other
