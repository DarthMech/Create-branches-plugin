package com.docdoc.plugin.branches

import org.junit.Assert.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object SimpleSpekTest : Spek({

    describe("Very simple test") {
            it("assertEquals 2 + 2") {
                assertEquals(4, 2 + 2)
            }

            it("assertEquals 2 + 3") {
                assertEquals(5, 2 + 3)
            }
    }

})