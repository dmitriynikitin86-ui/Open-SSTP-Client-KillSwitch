# Open-SSTP-Client (Mobile Resilience Patch)

**Original Project:** [Open-SSTP-Client by kittoku](https://github.com/kittoku/Open-SSTP-Client)  
**Mod Version:** `1.10.3-killswitch-mod`

---

### 📌 Navigation / Навигация

* 🇬🇧 **English Section (Below):**
  * Disclaimer & Project Status
  * Project Overview & Features
  * Source Code & Patch Availability
  * App Configuration
  * Patch Installation Guide
* ☒ **Русский раздел (Ниже):**
  * Дисклеймер и статус проекта
  * Описание проекта и функций
  * Доступность кода и патча
  * Настройка приложения
  * Инструкция по установке патча

---
---

# 🇬🇧 English Description

## ⚠️ Disclaimer

I am not a professional developer. I created this KillSwitch / socket flush modification to solve connection issues on unstable networks. 
* Modded version label: **`1.10.3-killswitch-mod`**
* This project has **not been stress-tested** for long-term fault tolerance or bulletproof security in production environments.
* Use this software at your own risk. Feedback and testing are welcome!

## 📝 Project Overview

This is a modified version of **Open-SSTP-Client** (version `1.10.3-killswitch-mod`). It was designed to enhance VPN stability on unstable mobile networks (frequent cell tower switching, short signal drops, DPI filtering):

* **Socket Flush (FlushVpnService):** Forces stale sockets to close when network changes or packet loss occurs.
* **Leak Protection:** Prevents unencrypted traffic from bypassing the VPN tunnel during reconnects.

## 📦 What's Included in This Repository

You have two options to use this modification:
1. **Full Source Code:** This repository contains the complete, ready-to-build application source code with all modifications pre-applied for version `1.10.3-killswitch-mod`.
2. **Standalone Patch File:** If you prefer working with the original upstream project, you can use the included `killswitch_fix.patch` file to apply these changes to the original code from `kittoku`.

## ⚙️ App Configuration

After installing the APK and adding your VPN profile:

1. Open **Settings** in your VPN connection profile.
2. Enable **Auto-reconnect / Restart VPN**.
3. Set reconnect attempts to maximum: **999+** (infinite retries).
4. Ensure **loop reconnect / cycling** is enabled.

> **Important:** Without infinite retries and loop cycling enabled, the client cannot automatically recover during long network dropouts.

## 🛠️ Patch Installation Guide

To build the APK from the original source code with this patch applied:

1. Clone the upstream repository:
   git clone https://github.com/kittoku/Open-SSTP-Client.git
   cd Open-SSTP-Client

2. Download the patch file:
   curl -O https://raw.githubusercontent.com/dmitriynikitin86-ui/Open-SSTP-Client-KillSwitch/main/killswitch_fix.patch

3. Apply the patch:
   git apply killswitch_fix.patch

4. Build the project:
   ./gradlew assembleDebug

---
---

# ☒ Описание на русском языке

## ⚠️ Дисклеймер

Я не являюсь профессиональным программистом. Данная модификация функции KillSwitch / сброса сокетов была создана как личная попытка решить проблему обрывов связи.
* Версия модификации: **`1.10.3-killswitch-mod`**
* Приложение **не проходило жестких тестов на отказоустойчивость** и безопасность в боевых условиях.
* Вы используете этот софт на свой страх и риск. Любые тесты и фидбек приветствуются!

## 📝 Описание проекта

Данный репозиторий содержит модификацию **`1.10.3-killswitch-mod`** для оригинального приложения **Open-SSTP-Client**. Модификация повышает стабильность VPN-соединения в нестабильных мобильных сетях (частая смена вышек, кратковременные обрывы связи, жесткое фильтрование DPI):

* **Принудительный сброс сокетов (FlushVpnService):** при смене сети или потере пакетов приложение принудительно очищает подвисшие соединения.
* **Защита от утечки данных:** предотвращает прохождение незашифрованного трафика мимо туннеля при переключениях сети.

## 📦 Варианты использования (Код и Патч)

В данном репозитории доступны два варианта работы:
1. **Полный исходный код:** Здесь выложен полностью готовый код приложения версии `1.10.3-killswitch-mod` со всеми внесенными правками (можно сразу собирать проект целиком).
2. **Файл патча:** В корне лежит файл `killswitch_fix.patch`. Вы можете взять чистый оригинальный код от автора `kittoku` и применить на него только этот файл патча.

## ⚙️ Настройка приложения

После установки APK-файла и импорта VPN-конфигурации:

1. Перейдите в **Настройки (Settings)** вашего VPN-профиля.
2. Включите опцию **Автопереподключение / Перезапуск VPN (Auto-reconnect)**.
3. Установите количество попыток подключения на максимум: **999+** (бесконечный повтор).
4. Убедитесь, что включена **цикличность переподключения**.

> **Важно:** Без включенной цикличности и бесконечного переподключения туннель не сможет автоматически восстанавливаться при длительных обрывах связи.

## 🛠️ Инструкция по установке патча

Чтобы применить патч и собрать APK из официального исходного кода:

1. Склонируйте оригинальный репозиторий:
   git clone https://github.com/kittoku/Open-SSTP-Client.git
   cd Open-SSTP-Client

2. Скачайте файл патча:
   curl -O https://raw.githubusercontent.com/dmitriynikitin86-ui/Open-SSTP-Client-KillSwitch/main/killswitch_fix.patch

3. Примените патч к коду:
   git apply killswitch_fix.patch

4. Соберите APK:
   ./gradlew assembleDebug
