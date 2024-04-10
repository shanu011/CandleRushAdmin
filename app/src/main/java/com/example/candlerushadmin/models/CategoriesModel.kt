package com.example.candlerushadmin.models

data class CategoriesModel(
    var categoryName:String?=null,
    var categoryImgUri: String?=null,
    var categoryId:String?=null,
//    var subCategoryList: ArrayList<SubCategory>? = arrayListOf()
)

data class SubCategory(
    var subCatName: String? = "",
    var subcatDescription:String?="",
    var subCatImage:String?="",
    var subCatId: String? = "",
    var categoryId: String?="",
    var subcatPrice:Int?=0
)
