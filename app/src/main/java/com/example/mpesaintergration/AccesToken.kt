package com.example.mpesaintergration

data class AccesToken(var BusinessShortCode:Int =  174379,
                      var Password:String =  "MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMTYwMjE2MTY1NjI3",
                      var Timestamp:String = "20160216165627",
                      var TransactionType: String = "CustomerPayBillOnline",
                      var Amount:Int,
                      var PartyA: Long ,
                      var PartyB:Int = 174379,
                      var PhoneNumber:Long = 254708374149,
                      var CallBackURL:String = "https://mydomain.com/pat",
                      var AccountReference:String = "Test",
                      var TransactionDesc:String = "Test"
    ) {
}
