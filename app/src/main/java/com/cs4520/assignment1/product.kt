package com.cs4520.assignment1

sealed class Product(val name: String, val price: Int, val expiryDate: String?);

class Equipment(name: String, price: Int, exp: String?): Product(name, price, exp);

class Food(name: String, price: Int, exp: String?): Product(name, price, exp);