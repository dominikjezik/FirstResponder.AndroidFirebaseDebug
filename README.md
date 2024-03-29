# Mobilná aplikácia určená pre ladenie systému First responder za použitia Firebase Cloud Messaging
Táto aplikácia vznikla ako súčasť bakalárskej práce [Webová časť systému First responder](https://github.com/dominikjezik/FirstResponder.WebApp) a je určená pre ladenie komunikácie medzi webovou časťou a mobilnou aplikáciou pomocou Firebase Cloud Messaging. Je využívaná z dôvodu nedostupnosti plnohodnotnej mobilnej aplikácie.

Systém First responder je určený na evidenciu vyškolených dobrovoľníkov (First responderov), ktorí môžu byť pomocou tohto systému vyslaní na pomoc. Tento systém je určený ako doplnok k záchranným službám hlavne v prípadoch, kedy dobrovoľník môže prísť na miesto skôr ako k pacientovi dorazí záchranná služba. Dobrovoľníci sú vyškolení v poskytovaní prvej pomoci a sú vybavení AED (Automatický Externý Defibrilátor) zariadením. First responderi sú upozornení na zásah pomocou mobilnej aplikácie.

Tento projekt bol realizovaný ako bakalárska práca na Fakulte riadenia a informatiky na Žilinskej univerzite v Žiline.


## Spustenie aplikácie
Pre spustenie aplikácie je potrebné mať vytvorený projekt v konzole Firebase a zaregistrovať Android aplikáciu. Následne je potrebné stiahnuť súbor `google-services.json` obsahujúci kľúč a informácie o projekte. Tento súbor je potrebné umiestniť do adresára `app` v rámci projektu aplikácie. Údaje z tohto súboru sú následne použité pri inicializácii knižnice Firebase Cloud Messaging.


## FCM notifikácie
Doposiaľ sú z webového systému odosielané nasledujúce typy notifikácií.


### 🛰️ Vyžiadanie polohy respondera
Po tom ako bol vytvorený zásah, zamestnanec má možnosť notifikovať responderov v okolí o zásahu. Toto notifikovanie vyžiada od responderov ich polohu, na základe ktorej sa responderom zobrazí nový zásah, ak sú v okolí zásahu.


### 🆘 Aktualizácia informácií o zásahu
Informácie o zásahu vrátane jeho polohy je možné priebežne aktualizovať. Keď zamestnanec aktualizuje informácie o zásahu, zaradení responderi sú o aktualizácii informovaní.


### 💬 Prijímanie správ zásahu
V prebiehaujúcom zásahu je možná výmena správ medzi zamestnancom a zaradenými respondermi. Po odoslaní správy zamestnancom alebo iným responderom je responder o tejto správe notifikovaný.


### 📲 Prijímanie (vizuálnych) notifikácií
Responderom je možné odosielať všeobecné informácie, ktoré sú zobrazené v notifikácii. Notifikácie sú vytvárané zamestnancom a určené sú pre konkrétneho respondera alebo skupinu responderov.
