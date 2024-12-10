package models
import org.example.controllers.Punt
import org.example.controllers.translacio
import org.example.controllers.iguals
import org.example.controllers.escalat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MyModelTest {
    @Test
    fun testTranslacio1() {
        val p = Punt(2.0f, 3.0f)
        val desp = Punt(1.0f, 1.0f)
        translacio(p, desp)
        assertEquals(3.0f, p.x)
        assertEquals(4.0f, p.y)
    }

    @Test
    fun testTranslacio2() {
        val p = Punt(5.0f, 5.0f)
        val desp = Punt(0.0f, 0.0f)
        translacio(p, desp)
        assertEquals(5.0f, p.x)
        assertEquals(5.0f, p.y)
    }

    @Test
    fun testTranslacio3() {
        val p = Punt(2.0f, 2.0f)
        val desp = Punt(-3.0f, -1.0f)
        translacio(p, desp)
        assertEquals(-1.0f, p.x)
        assertEquals(1.0f, p.y)
    }

    // Tests per escalat
    @Test
    fun testEscalat1() {
        val p = Punt(2.0f, 3.0f)
        escalat(p, 2.0f)
        assertEquals(4.0f, p.x)
        assertEquals(6.0f, p.y)
    }

    @Test
    fun testEscalat2() {
        val p = Punt(1.5f, -2.5f)
        escalat(p, 1.0f)
        assertEquals(1.5f, p.x)
        assertEquals(-2.5f, p.y)
    }

    @Test
    fun testEscalat3() {
        val p = Punt(3.0f, 4.0f)
        escalat(p, -1.0f)
        assertEquals(-3.0f, p.x)
        assertEquals(-4.0f, p.y)
    }

    // Tests per iguals
    @Test
    fun testIguals1() {
        val p1 = Punt(2.0f, 3.0f)
        val p2 = Punt(2.0f, 3.0f)
        assertTrue(iguals(p1, p2))
    }

    @Test
    fun testIguals2() {
        val p1 = Punt(2.0f, 3.0f)
        val p2 = Punt(2.1f, 3.0f)
        assertFalse(iguals(p1, p2))
    }

    @Test
    fun testIguals3() {
        val p1 = Punt(2.0f, 3.0f)
        val p2 = Punt(2.0f, 3.1f)
        assertFalse(iguals(p1, p2))
    }
}
