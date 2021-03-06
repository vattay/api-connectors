/**
 * BitMEX API
 * ## REST API for the BitMEX Trading Platform  [Changelog](/app/apiChangelog)  ----  #### Getting Started   ##### Fetching Data  All REST endpoints are documented below. You can try out any query right from this interface.  Most table queries accept `count`, `start`, and `reverse` params. Set `reverse=true` to get rows newest-first.  Additional documentation regarding filters, timestamps, and authentication is available in [the main API documentation](https://www.bitmex.com/app/restAPI).  *All* table data is available via the [Websocket](/app/wsAPI). We highly recommend using the socket if you want to have the quickest possible data without being subject to ratelimits.  ##### Return Types  By default, all data is returned as JSON. Send `?_format=csv` to get CSV data or `?_format=xml` to get XML data.  ##### Trade Data Queries  *This is only a small subset of what is available, to get you started.*  Fill in the parameters and click the `Try it out!` button to try any of these queries.  * [Pricing Data](#!/Quote/Quote_get)  * [Trade Data](#!/Trade/Trade_get)  * [OrderBook Data](#!/OrderBook/OrderBook_getL2)  * [Settlement Data](#!/Settlement/Settlement_get)  * [Exchange Statistics](#!/Stats/Stats_history)  Every function of the BitMEX.com platform is exposed here and documented. Many more functions are available.  ---  ## All API Endpoints  Click to expand a section. 
 *
 * OpenAPI spec version: 1.2.0
 * Contact: support@bitmex.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.swagger.client.api

import io.swagger.client.model.Order
import io.swagger.client.model.Number
import io.swagger.client.model.Error
import java.util.Date
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class OrderApi(val defBasePath: String = "https://localhost/api/v1",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  /**
   * Amend the quantity or price of an open order.
   * Send an &#x60;orderID&#x60; or &#x60;origClOrdID&#x60; to identify the order you wish to amend.  Both order quantity and price can be amended. Only one &#x60;qty&#x60; field can be used to amend.  Use the &#x60;leavesQty&#x60; field to specify how much of the order you wish to remain open. This can be useful if you want to adjust your position&#39;s delta by a certain amount, regardless of how much of the order has already filled.  Use the &#x60;simpleOrderQty&#x60; and &#x60;simpleLeavesQty&#x60; fields to specify order size in Bitcoin, rather than contracts. These fields will round up to the nearest contract.  Like order placement, amending can be done in bulk. Simply send a request to &#x60;PUT /api/v1/order/bulk&#x60; with a JSON body of the shape: &#x60;{\&quot;orders\&quot;: [{...}, {...}]}&#x60;, each object containing the fields used in this endpoint. 
   * @param orderID Order ID (optional)
   * @param origClOrdID Client Order ID. See POST /order. (optional)
   * @param clOrdID Optional new Client Order ID, requires &#x60;origClOrdID&#x60;. (optional)
   * @param simpleOrderQty Optional order quantity in units of the underlying instrument (i.e. Bitcoin). (optional)
   * @param orderQty Optional order quantity in units of the instrument (i.e. contracts). (optional)
   * @param simpleLeavesQty Optional leaves quantity in units of the underlying instrument (i.e. Bitcoin). Useful for amending partially filled orders. (optional)
   * @param leavesQty Optional leaves quantity in units of the instrument (i.e. contracts). Useful for amending partially filled orders. (optional)
   * @param price Optional limit price for &#39;Limit&#39;, &#39;StopLimit&#39;, and &#39;LimitIfTouched&#39; orders. (optional)
   * @param stopPx Optional trigger price for &#39;Stop&#39;, &#39;StopLimit&#39;, &#39;MarketIfTouched&#39;, and &#39;LimitIfTouched&#39; orders. Use a price below the current price for stop-sell orders and buy-if-touched orders. (optional)
   * @param pegOffsetValue Optional trailing offset from the current price for &#39;Stop&#39;, &#39;StopLimit&#39;, &#39;MarketIfTouched&#39;, and &#39;LimitIfTouched&#39; orders; use a negative offset for stop-sell orders and buy-if-touched orders. Optional offset from the peg price for &#39;Pegged&#39; orders. (optional)
   * @param text Optional amend annotation. e.g. &#39;Adjust skew&#39;. (optional)
   * @return Order
   */
  def orderAmend (orderID: String, origClOrdID: String, clOrdID: String, simpleOrderQty: Double, orderQty: Number, simpleLeavesQty: Double, leavesQty: Number, price: Double, stopPx: Double, pegOffsetValue: Double, text: String) : Option[Order] = {
    // create path and map variables
    val path = "/order".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

        
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("orderID", orderID.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("origClOrdID", origClOrdID.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("clOrdID", clOrdID.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("simpleOrderQty", simpleOrderQty.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("orderQty", orderQty.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("simpleLeavesQty", simpleLeavesQty.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("leavesQty", leavesQty.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("price", price.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("stopPx", stopPx.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("pegOffsetValue", pegOffsetValue.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("text", text.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "orderID" -> orderID.toString()
      formParams += "origClOrdID" -> origClOrdID.toString()
      formParams += "clOrdID" -> clOrdID.toString()
      formParams += "simpleOrderQty" -> simpleOrderQty.toString()
      formParams += "orderQty" -> orderQty.toString()
      formParams += "simpleLeavesQty" -> simpleLeavesQty.toString()
      formParams += "leavesQty" -> leavesQty.toString()
      formParams += "price" -> price.toString()
      formParams += "stopPx" -> stopPx.toString()
      formParams += "pegOffsetValue" -> pegOffsetValue.toString()
      formParams += "text" -> text.toString()
    }

    try {
      apiInvoker.invokeApi(basePath, path, "PUT", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Order]).asInstanceOf[Order])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Amend multiple orders.
   * Similar to POST /amend, but with multiple orders. &#x60;application/json&#x60; only. Ratelimited at 50%.
   * @param orders An array of orders. (optional)
   * @return List[Order]
   */
  def orderAmendBulk (orders: String) : Option[List[Order]] = {
    // create path and map variables
    val path = "/order/bulk".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

        
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("orders", orders.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "orders" -> orders.toString()
    }

    try {
      apiInvoker.invokeApi(basePath, path, "PUT", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Order]).asInstanceOf[List[Order]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Cancel order(s). Send multiple order IDs to cancel in bulk.
   * Either an orderID or a clOrdID must be provided.
   * @param orderID Order ID(s). (optional)
   * @param clOrdID Client Order ID(s). See POST /order. (optional)
   * @param text Optional cancellation annotation. e.g. &#39;Spread Exceeded&#39;. (optional)
   * @return List[Order]
   */
  def orderCancel (orderID: String, clOrdID: String, text: String) : Option[List[Order]] = {
    // create path and map variables
    val path = "/order".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

        
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("orderID", orderID.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("clOrdID", clOrdID.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("text", text.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "orderID" -> orderID.toString()
      formParams += "clOrdID" -> clOrdID.toString()
      formParams += "text" -> text.toString()
    }

    try {
      apiInvoker.invokeApi(basePath, path, "DELETE", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Order]).asInstanceOf[List[Order]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Cancels all of your orders.
   * 
   * @param symbol Optional symbol. If provided, only cancels orders for that symbol. (optional)
   * @param filter Optional filter for cancellation. Use to only cancel some orders, e.g. &#x60;{\&quot;side\&quot;: \&quot;Buy\&quot;}&#x60;. (optional)
   * @param text Optional cancellation annotation. e.g. &#39;Spread Exceeded&#39; (optional)
   * @return Any
   */
  def orderCancelAll (symbol: String, filter: String, text: String) : Option[Any] = {
    // create path and map variables
    val path = "/order/all".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

        
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("symbol", symbol.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("filter", filter.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("text", text.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "symbol" -> symbol.toString()
      formParams += "filter" -> filter.toString()
      formParams += "text" -> text.toString()
    }

    try {
      apiInvoker.invokeApi(basePath, path, "DELETE", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Any]).asInstanceOf[Any])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Automatically cancel all your orders after a specified timeout.
   * Useful as a dead-man&#39;s switch to ensure your orders are canceled in case of an outage. If called repeatedly, the existing offset will be canceled and a new one will be inserted in its place.  Example usage: call this route at 15s intervals with an offset of 60000 (60s). If this route is not called within 60 seconds, all your orders will be automatically canceled.  This is also available via [WebSocket](https://www.bitmex.com/app/wsAPI#dead-man-s-switch-auto-cancel-). 
   * @param timeout Timeout in ms. Set to 0 to cancel this timer.  
   * @return Any
   */
  def orderCancelAllAfter (timeout: Double) : Option[Any] = {
    // create path and map variables
    val path = "/order/cancelAllAfter".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

        
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("timeout", timeout.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "timeout" -> timeout.toString()
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Any]).asInstanceOf[Any])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Close a position. [Deprecated, use POST /order with execInst: &#39;Close&#39;]
   * If no &#x60;price&#x60; is specified, a market order will be submitted to close the whole of your position. This will also close all other open orders in this symbol.
   * @param symbol Symbol of position to close. 
   * @param price Optional limit price. (optional)
   * @return Order
   */
  def orderClosePosition (symbol: String, price: Double) : Option[Order] = {
    // create path and map variables
    val path = "/order/closePosition".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

        
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("symbol", symbol.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("price", price.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "symbol" -> symbol.toString()
      formParams += "price" -> price.toString()
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Order]).asInstanceOf[Order])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get your orders.
   * To get open orders only, send {\&quot;open\&quot;: true} in the filter param.  See &lt;a href&#x3D;\&quot;http://www.onixs.biz/fix-dictionary/5.0.SP2/msgType_D_68.html\&quot;&gt;the FIX Spec&lt;/a&gt; for explanations of these fields.
   * @param symbol Instrument symbol. Send a bare series (e.g. XBU) to get data for the nearest expiring contract in that series.  You can also send a timeframe, e.g. &#x60;XBU:monthly&#x60;. Timeframes are &#x60;daily&#x60;, &#x60;weekly&#x60;, &#x60;monthly&#x60;, &#x60;quarterly&#x60;, and &#x60;biquarterly&#x60;. (optional)
   * @param filter Generic table filter. Send JSON key/value pairs, such as &#x60;{\&quot;key\&quot;: \&quot;value\&quot;}&#x60;. You can key on individual fields, and do more advanced querying on timestamps. See the [Timestamp Docs](https://www.bitmex.com/app/restAPI#timestamp-filters) for more details. (optional)
   * @param columns Array of column names to fetch. If omitted, will return all columns.  Note that this method will always return item keys, even when not specified, so you may receive more columns that you expect. (optional)
   * @param count Number of results to fetch. (optional, default to 100)
   * @param start Starting point for results. (optional, default to 0)
   * @param reverse If true, will sort results newest first. (optional, default to false)
   * @param startTime Starting date filter for results. (optional)
   * @param endTime Ending date filter for results. (optional)
   * @return List[Order]
   */
  def orderGetOrders (symbol: String, filter: String, columns: String, count: Number /* = 100 */, start: Number /* = 0 */, reverse: Boolean /* = false */, startTime: Date, endTime: Date) : Option[List[Order]] = {
    // create path and map variables
    val path = "/order".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(symbol) != "null") queryParams += "symbol" -> symbol.toString
if(String.valueOf(filter) != "null") queryParams += "filter" -> filter.toString
if(String.valueOf(columns) != "null") queryParams += "columns" -> columns.toString
if(String.valueOf(count) != "null") queryParams += "count" -> count.toString
if(String.valueOf(start) != "null") queryParams += "start" -> start.toString
if(String.valueOf(reverse) != "null") queryParams += "reverse" -> reverse.toString
if(String.valueOf(startTime) != "null") queryParams += "startTime" -> startTime.toString
if(String.valueOf(endTime) != "null") queryParams += "endTime" -> endTime.toString
    
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Order]).asInstanceOf[List[Order]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Create a new order.
   * This endpoint is used for placing orders. Valid order types are Market, Limit, Stop, StopLimit, MarketIfTouched, LimitIfTouched, MarketWithLeftOverAsLimit, and Pegged.  If no order type is provided, BitMEX will assume &#39;Limit&#39;. Be very careful with &#39;Market&#39; and &#39;Stop&#39; orders as you may be filled at an unfavourable price.  You can submit bulk orders by POSTing an array of orders to &#x60;/api/v1/order/bulk&#x60;. Send a JSON payload with the shape: &#x60;{\&quot;orders\&quot;: [{...}, {...}]}&#x60;, with each inner object containing the same fields that would be sent to this endpoint.  A note on API tools: if you want to keep track of order IDs yourself, set a unique clOrdID per order. This clOrdID will come back as a property on the order and any related executions (including on the WebSocket), and can be used to get or cancel the order. Max length is 36 characters.  To generate a clOrdID, consider setting a prefix, and incrementing a counter or generating a UUID. Some UUIDs are longer than 36 characters, so use a url-safe base64 encoding. For example, the prefix &#x60;&#39;bmex_mm_&#39;&#x60; and the UUID &#x60;&#39;7fbd6545-bb0c-11e4-a273-6003088a7c04&#39;&#x60; creates &#x60;&#39;bmex_mm_f71lRbsMEeSic2ADCIp8BA&#39;&#x60;.  See the [BitMEX Reference Market Maker](https://github.com/BitMEX/market-maker/blob/22c75a2b6db63e20212813e9afdb845db1b09b2a/bitmex.py#L152) for an example of how to use and generate clOrdIDs. 
   * @param symbol Instrument symbol. e.g. &#39;XBT24H&#39;. 
   * @param side Order side. Valid options: Buy, Sell. Defaults to &#39;Buy&#39; unless &#x60;orderQty&#x60; or &#x60;simpleOrderQty&#x60; is negative. (optional)
   * @param simpleOrderQty Order quantity in units of the underlying instrument (i.e. Bitcoin). (optional)
   * @param quantity Deprecated: use &#x60;orderQty&#x60;. (optional)
   * @param orderQty Order quantity in units of the instrument (i.e. contracts). (optional)
   * @param price Optional limit price for &#39;Limit&#39;, &#39;StopLimit&#39;, and &#39;LimitIfTouched&#39; orders. (optional)
   * @param displayQty Optional quantity to display in the book. Use 0 for a hidden order. (optional)
   * @param stopPrice Deprecated: use &#x60;stopPx&#x60;. (optional)
   * @param stopPx Optional trigger price for &#39;Stop&#39;, &#39;StopLimit&#39;, &#39;MarketIfTouched&#39;, and &#39;LimitIfTouched&#39; orders. Use a price below the current price for stop-sell orders and buy-if-touched orders. Use &#x60;execInst&#x60; of &#39;MarkPrice&#39; or &#39;LastPrice&#39; to define the current price used for triggering. (optional)
   * @param clOrdID Optional Client Order ID. This clOrdID will come back on the order and any related executions. (optional)
   * @param clOrdLinkID Optional Client Order Link ID for contingent orders. (optional)
   * @param pegOffsetValue Optional trailing offset from the current price for &#39;Stop&#39;, &#39;StopLimit&#39;, &#39;MarketIfTouched&#39;, and &#39;LimitIfTouched&#39; orders; use a negative offset for stop-sell orders and buy-if-touched orders. Optional offset from the peg price for &#39;Pegged&#39; orders. (optional)
   * @param pegPriceType Optional peg price type. Valid options: LastPeg, MidPricePeg, MarketPeg, PrimaryPeg, TrailingStopPeg, TrailingStopPeg. (optional)
   * @param _type Deprecated: use &#x60;ordType&#x60;. (optional)
   * @param ordType Order type. Valid options: Market, Limit, Stop, StopLimit, MarketIfTouched, LimitIfTouched, MarketWithLeftOverAsLimit, Pegged. Defaults to &#39;Limit&#39; when &#x60;price&#x60; is specified. Defaults to &#39;Stop&#39; when &#x60;stopPx&#x60; is specified. Defaults to &#39;StopLimit&#39; when &#x60;price&#x60; and &#x60;stopPx&#x60; are specified. (optional, default to Limit)
   * @param timeInForce Time in force. Valid options: Day, GoodTillCancel, ImmediateOrCancel, FillOrKill. Defaults to &#39;GoodTillCancel&#39; for &#39;Limit&#39;, &#39;StopLimit&#39;, &#39;LimitIfTouched&#39;, and &#39;MarketWithLeftOverAsLimit&#39; orders. (optional)
   * @param execInst Optional execution instructions. Valid options: ParticipateDoNotInitiate, AllOrNone, MarkPrice, IndexPrice, LastPrice, Close, ReduceOnly, Fixed. &#39;AllOrNone&#39; instruction requires &#x60;displayQty&#x60; to be 0. &#39;MarkPrice&#39; or &#39;LastPrice&#39; instruction valid for &#39;Stop&#39;, &#39;StopLimit&#39;, &#39;MarketIfTouched&#39;, and &#39;LimitIfTouched&#39; orders. (optional)
   * @param contingencyType Optional contingency type for use with &#x60;clOrdLinkID&#x60;. Valid options: OneCancelsTheOther, OneTriggersTheOther, OneUpdatesTheOtherAbsolute, OneUpdatesTheOtherProportional. (optional)
   * @param text Optional order annotation. e.g. &#39;Take profit&#39;. (optional)
   * @return Order
   */
  def orderNew (symbol: String, side: String, simpleOrderQty: Double, quantity: Number, orderQty: Number, price: Double, displayQty: Number, stopPrice: Double, stopPx: Double, clOrdID: String, clOrdLinkID: String, pegOffsetValue: Double, pegPriceType: String, _type: String, ordType: String /* = Limit */, timeInForce: String, execInst: String, contingencyType: String, text: String) : Option[Order] = {
    // create path and map variables
    val path = "/order".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

        
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("symbol", symbol.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("side", side.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("simpleOrderQty", simpleOrderQty.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("quantity", quantity.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("orderQty", orderQty.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("price", price.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("displayQty", displayQty.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("stopPrice", stopPrice.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("stopPx", stopPx.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("clOrdID", clOrdID.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("clOrdLinkID", clOrdLinkID.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("pegOffsetValue", pegOffsetValue.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("pegPriceType", pegPriceType.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("type", _type.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("ordType", ordType.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("timeInForce", timeInForce.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("execInst", execInst.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("contingencyType", contingencyType.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("text", text.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "symbol" -> symbol.toString()
      formParams += "side" -> side.toString()
      formParams += "simpleOrderQty" -> simpleOrderQty.toString()
      formParams += "quantity" -> quantity.toString()
      formParams += "orderQty" -> orderQty.toString()
      formParams += "price" -> price.toString()
      formParams += "displayQty" -> displayQty.toString()
      formParams += "stopPrice" -> stopPrice.toString()
      formParams += "stopPx" -> stopPx.toString()
      formParams += "clOrdID" -> clOrdID.toString()
      formParams += "clOrdLinkID" -> clOrdLinkID.toString()
      formParams += "pegOffsetValue" -> pegOffsetValue.toString()
      formParams += "pegPriceType" -> pegPriceType.toString()
      formParams += "type" -> _type.toString()
      formParams += "ordType" -> ordType.toString()
      formParams += "timeInForce" -> timeInForce.toString()
      formParams += "execInst" -> execInst.toString()
      formParams += "contingencyType" -> contingencyType.toString()
      formParams += "text" -> text.toString()
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Order]).asInstanceOf[Order])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Create multiple new orders.
   * This endpoint is used for placing bulk orders. Valid order types are Market, Limit, Stop, StopLimit, MarketIfTouched, LimitIfTouched, MarketWithLeftOverAsLimit, and Pegged.  Each individual order object in the array should have the same properties as an individual POST /order call.  This endpoint is much faster for getting many orders into the book at once. Because it reduces load on BitMEX systems, this endpoint is ratelimited at &#x60;ceil(0.5 * orders)&#x60;. Submitting 10 orders via a bulk order call will only count as 5 requests.  For now, only &#x60;application/json&#x60; is supported on this endpoint. 
   * @param orders An array of orders. (optional)
   * @return List[Order]
   */
  def orderNewBulk (orders: String) : Option[List[Order]] = {
    // create path and map variables
    val path = "/order/bulk".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

        
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("orders", orders.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "orders" -> orders.toString()
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Order]).asInstanceOf[List[Order]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

}
