package org.superchat.placeholderHandler

import org.superchat.message.MessageDto
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PlaceholderService {
    @Inject
    lateinit var btcPlaceholder: BtcPlaceholder
    @Inject
    lateinit var namePlaceholder: NamePlaceholder

    fun gatherPlaceholders(msg: String): List<String> {
        val regex = Regex("(@sprcht_)\\w*")
        return regex.findAll(msg)
            .map { matchResult -> matchResult.value  }
            .toList()
    }

    fun replacePlaceholders(dto: MessageDto): MessageDto {
        val words = gatherPlaceholders(dto.body)
        var msgBody = dto.body
        words.forEach {
            msgBody = when(it) {
                "@sprcht_btc" -> {
                    val btcVal = btcPlaceholder.handle()
                    msgBody.replace(it, btcVal)
                }
                "@sprcht_name" -> {
                    val nameVal = namePlaceholder.handle(dto.conversationId)
                    msgBody.replace(it, nameVal)
                }
                else -> throw RuntimeException("Unsupported placeholder $it")
            }
        }

        return MessageDto(dto.conversationId, dto.author, msgBody)
    }
}