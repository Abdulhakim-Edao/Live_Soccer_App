package com.example.fragments.ui.fixtures

class ParentItem(
    // Getter and Setter methods
    // for each parameter
    // Declaration of the variables
    var parentItemTitle: String,
    ChildItemList: List<Days>
) {
    private var ChildItemList: List<Days>

    // Constructor of the class
    // to initialize the variables
    init {
        this.ChildItemList = ChildItemList
    }

    fun getChildItemList(): List<Days> {
        return ChildItemList
    }

    fun setChildItemList(
        childItemList: List<Days>
    ) {
        ChildItemList = childItemList
    }
}
