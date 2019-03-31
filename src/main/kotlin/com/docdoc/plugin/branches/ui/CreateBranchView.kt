package com.docdoc.plugin.branches.ui

import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import java.awt.Dimension
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.*

class CreateBranchView(branchType: String)  {

    private val presenter: CreateBranchPresenter = CreateBranchPresenter(branchType)

    val idTextField = JTextField("")
    private val branchNameLabel = JLabel("${presenter.branchType}/DD-/")
    private val labelTextField = JTextField("")

    val mainPanel = panel {
        row("$branchType/DD-{ID}/{Label}") {}
        row("ID: ") { idTextField(CCFlags.pushX, CCFlags.push) }
        row("Label: ") { labelTextField(CCFlags.grow, CCFlags.push) }
        row { branchNameLabel(CCFlags.grow, CCFlags.push) }
    }

    private val listener =  object : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
        }
        override fun keyPressed(e: KeyEvent?) {
        }
        override fun keyReleased(e: KeyEvent?) {
            branchNameLabel.text = getBranchName()
        }
    }

    init {
        mainPanel.preferredSize = Dimension(400, 100)

        idTextField.addKeyListener(listener)
        labelTextField.addKeyListener(listener)
    }

    fun getBranchName() = presenter.getBranchName(idTextField.text, labelTextField.text)
}