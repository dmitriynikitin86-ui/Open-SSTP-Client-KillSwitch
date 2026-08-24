package kittoku.osc.service

import android.content.Intent
import android.net.VpnService

class FlushVpnService : VpnService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try {
            // Поднимаем фейковый туннель на 10 мс, чтобы Android отозвал права у главного VPN
            Builder().setSession("Flush").addAddress("192.0.2.1", 32).establish()?.close()
        } catch (_: Exception) {}
        stopSelf()
        return START_NOT_STICKY
    }
}
