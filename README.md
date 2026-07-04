# Ziegenhof-Simulator

Ein interaktives Klickspiel, entwickelt in Java. Dieses Projekt demonstriert die Grundlagen der objektorientierten Programmierung (OOP) und der grafischen Benutzeroberflächen-Entwicklung.

## Features
* **Interaktives Gameplay:** Durch Klicken auf Buttons, kauft man sich Land, Ställe und Ziegen. Die produzierte Ziegenmilch wird verkauft und man muss damit Millonär werden.
* **Upgrades:** Fast alles kann geupgradet werden um es effizienter zu nutzen (z.b. 4 Gebäude pro Land statt nur 3 Gebäude).
* **Score-Tracking:** Am Ende jedes In-Game Jahres wird eine Übersicht der Ein- und Ausgaben angezeigt.
* **Futtersystem** Ziegen müssen essen um nicht krank zu werden. Kranke Ziegen geben weniger Milch.

* ## Gameplay / Steuerung
- Linksklick: Ziege melken
- Buttons: Milch verkaufen, Upgrades kaufen
- Ziel: 1.000.000 Geld in so wenig Tagen(Ticks) wie möglich

## Technologien & Konzepte
* **Programmiersprache:** Java 
* **GUI-Framework:** [Java Swing / AWT ]
* **OOP-Konzepte:** Klassenstrukturierung, Event-Handling (ActionListener) und Kapselung.

## Installation & Voraussetzungen
Um das Projekt lokal auszuführen, benötigst du ein installiertes Java Development Kit (JDK).

1. Lade den Projektordner herunter und entpacke die ZIP-Datei.
2. Öffne das Terminal / die Eingabeaufforderung in diesem Ordner.

## Projekt starten
Du kannst das Spiel entweder direkt über deine IDE (z. B. IntelliJ, Eclipse) starten oder über die Konsole kompilieren und ausführen:

```bash
# Code kompilieren
javac src/*.java

# Spiel starten
java src/GameStart
```

## 💡 Lerneffekte
Bei der Umsetzung dieses Projekts habe ich folgende Kernkompetenzen vertieft:
1. **Event-Driven Programming:** Wie Benutzeroberflächen auf Benutzereingaben reagieren.
2. **Code-Strukturierung:** Trennung von Spiellogik (Daten) und UI-Anzeige.
3. **Fehlerbehebung:** Debugging von Logikfehlern bei der Punkteberechnung.# Ziegenhof-Simulator

## Screenshots
Füge hier ein Bild ein:
![Gameplay](docs/screenshot.png)

## Mitmachen / Contributing
Siehe CONTRIBUTING.md

## License
Dieses Projekt ist lizenziert unter der MIT License — siehe LICENSE.
