package com.example.customviews.totalDues

import java.io.Serializable

data class TotalDues(
    val totalDues: String,
    val cardDues: List<CardDue>
): Serializable {
    companion object {
        val dummyData get() =
            TotalDues(
                totalDues = "₹ 60000",
                cardDues = listOf(
                    CardDue(
                        logo = "https://companieslogo.com/img/orig/AXISBANK.BO-8f59e95b.png?t=1672905040",
                        cardName = "Axis Platinum",
                        cardType = "Credit Card",
                        billingType = BillingType.BillDue(
                            dueAmount = "₹30,000.06",
                            overdueTime = "Overdue by 1 Day"
                        )
                    ),
                    CardDue(
                        logo = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/SBI-logo.svg/2048px-SBI-logo.svg.png",
                        cardName = "SBI Simply Click",
                        cardType = "Credit Card",
                        billingType = BillingType.BillDue(
                            dueAmount = "₹30,000.06",
                            overdueTime = "Due in 3 Days"
                        )
                    ),
                    CardDue(
                        logo = "https://companieslogo.com/img/orig/BANKBARODA.NS-6790b239.png?t=1604067029",
                        cardName = "BOB Credit Platinum",
                        cardType = "Credit Card",
                        billingType = BillingType.NoBillFound(
                            message = "No bill found"
                        )
                    ),
                )
            )
    }
}

sealed class BillingType: Serializable {

    data class BillDue(
        val dueAmount: String,
        val overdueTime: String,
    ): BillingType(), Serializable

    data class NoBillFound(
        val message: String,
    ): BillingType(), Serializable

}

data class CardDue(
    val logo: String?,
    val cardName: String,
    val cardType: String,
    val billingType: BillingType
): Serializable
