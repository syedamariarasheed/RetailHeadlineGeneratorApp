package com.example.myfirstaiapp.data

import com.example.myfirstaiapp.data.model.DiscountedItems
import com.example.myfirstaiapp.data.model.PastHistory

val pastHistory = arrayListOf(
    PastHistory(
        category = "Rice",
        item = "Mugghaal Basmati",
        price = 450.0
    ),
    PastHistory(
        category = "Rice",
        item = "Mugghaal Kernal Basmati",
        price = 550.0
    ),
    PastHistory(
        category = "Tea",
        item = "Lipton",
        price = 900.0
    ),
    PastHistory(
        category = "Toothpaste",
        item = "Colgate",
        price = 230.0
    )
)

val discountedItems = arrayListOf(
    DiscountedItems(
        category = "Dairy",
        item = "Milk pak",
        price = 200.0,
        discountedPrice = 100.0
    ),
    DiscountedItems(
        category = "Dairy",
        item = "Bread",
        price = 210.0,
        discountedPrice = 200.0
    ),
    DiscountedItems(
        category = "Rice",
        item = "Falaakk Brand Rice",
        price = 630.0,
        discountedPrice = 400.0
    ),
    DiscountedItems(
        category = "Rice",
        item = "Mugghaal Basmati",
        price = 450.0,
        discountedPrice = 420.0
    ),
    DiscountedItems(
        category = "Cosmetics",
        item = "XYZ Eyeliner",
        price = 2000.0,
        discountedPrice = 1000.0
    )

)