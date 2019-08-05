package com.docdoc.plugin.branches.ui

class CreateBranchPresenter(val branchType: String) {

    fun getBranchName(
            project: String,
            id: String,
            label: String
    ) = "$branchType/$project-$id/$label"
}