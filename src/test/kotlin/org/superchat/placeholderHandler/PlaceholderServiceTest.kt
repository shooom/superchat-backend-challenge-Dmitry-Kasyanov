package org.superchat.placeholderHandler

import io.mockk.every
import io.quarkiverse.test.junit.mockk.InjectMock
import io.quarkus.test.junit.QuarkusTest
import org.superchat.message.MessageDto
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@QuarkusTest
internal class PlaceholderServiceTest {

    @InjectMock
    lateinit var btcPlaceholder: BtcPlaceholder
    @InjectMock
    lateinit var namePlaceholder: NamePlaceholder

    lateinit var placeholderService: PlaceholderService;

    @BeforeTest
    fun init() {
        placeholderService = PlaceholderService()
        placeholderService.btcPlaceholder = btcPlaceholder
        placeholderService.namePlaceholder = namePlaceholder

        every { btcPlaceholder.handle() } returns "33 333.33"
        every { namePlaceholder.handle(any()) } returns "Foo Buzz"
    }

    @Test
    fun gatherPlaceholders() {
        val expected = "@sprcht_name"
        val message = "Hi, @sprcht_name! How are you?"

        assertEquals(expected, placeholderService.gatherPlaceholders(message)[0])
    }

    @Test
    fun gatherPlaceholders_return_two_placeholders() {
        val expected = 2
        val message = "Hi, @sprcht_name! Do you know that BTC price is @sprcht_btc$ now?"

        assertEquals(expected, placeholderService.gatherPlaceholders(message).size)
    }

    @Test
    fun replacePlaceholders_success() {
        val message = "Hi, @sprcht_name! Do you know that BTC price is @sprcht_btc$ now?"
        val expected = "Hi, Foo Buzz! Do you know that BTC price is 33 333.33$ now?"
        val dto = MessageDto(1, "@FooBuzz", message)
        assertEquals(expected, placeholderService.replacePlaceholders(dto).body)
    }

    @Test
    fun replacePlaceholders_success_without_placeholders() {
        val message = "Hi, Foo Buzz! Do you know that BTC price is 33 333.33$ now?"
        val dto = MessageDto(1, "@FooBuzz", message)
        assertEquals(message, placeholderService.replacePlaceholders(dto).body)
    }

    @Test
    fun replacePlaceholders_throws_exception_for_unsupported_placeholder() {
        val message = "Hi, @sprcht_name! Did you know that TON's price is @sprcht_ton?"
        val dto = MessageDto(1, "@FooBuzz", message)
        assertFailsWith<RuntimeException>(
            "Unsupported placeholder @sprcht_ton"
        ) { placeholderService.replacePlaceholders(dto) }
    }
}