package com.docdoc.plugin.branches.actions

class CreateFixBranchAction : BaseBranchAction(BranchesType.HOT_FIX) {
    init {
        templatePresentation.text = "HotFix"
    }
}