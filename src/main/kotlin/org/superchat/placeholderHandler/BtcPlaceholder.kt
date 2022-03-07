package org.superchat.placeholderHandler

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BtcPlaceholder {
    //TODO add REST client and get BTC price by API
    fun handle() = "36 057,21"
}