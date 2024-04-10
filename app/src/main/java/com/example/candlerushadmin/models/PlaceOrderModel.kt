package com.example.candlerushadmin.models

import java.io.Serializable

data class PlaceOrderModel(
    var orderid:String?="",
    var userid: String? = "",
    var productImage:String?="",
    var productName:String?="",
    var productDes:String?="",
    var productPrice: Int?=0,
    var productColor:String?="",
    var productFragrance:String?="",
    var productShape:String?="",
    var productSize:String?=""
    ):Serializable
