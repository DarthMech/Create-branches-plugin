package com.docdoc.plugin.branches.ui

class CreateBranchPresenter(val branchType: String) {

    fun getBranchName(id: String, label: String) = "$branchType/DD-$id/$label"
}