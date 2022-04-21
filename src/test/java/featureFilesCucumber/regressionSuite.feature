Feature: Application Login

  Scenario Outline:  Login QA
    Given Benutzerdaten vorhanden
    When Benutzer loggt sich mit seinem <QA_Benutzername> und <QA_Passwort> auf QA ein
    Then Login erfolgreich

    Examples:
      | QA_Benutzername | QA_Passwort  |
      | deichmann       | 2019ciasoM   |


  Scenario Outline:  Registrierung
    Given Benutzerdaten vorhanden
    When Benutzer loggt sich mit seinem <Benutzername> und <Passwort> auf QA ein
    And Benutzer navigiert zur Registrierungsseite
    And Benutzer wählt ein Geschlecht im Checkbox aus
    And Benutzer füllt das Registrierungsformular aus <Vorname> <Nachname> <Email> <Passwort> <Straße> <Hausnummer> <Postleizahl> <Stadt>
    And Benutzer akzeptiert die Datenbestimmung
    And Benutzer klickt auf Jetzt Registrieren
    Then Benutzer ist erfolgreich registriert
    Examples:
      | Benutzername | Passwort  | Vorname         |Nachname          | Email           | Passwort      | Straße     | Hausnummer | Postleizahl| Stadt     |
      | deichmann    | 2019ciasoM| BenutzerVorname | BenutzerNachname | email@test.de   |  Passwort1234 | TestStraße | 17         | 42389      | Wuppertal |
      | deichmann    | 2019ciasoM| BenutzerVorname2| BenutzerNachname2| email2@test2.de |  Passwort1234 | TestStraße2| 172        | 44225      | Dortmund  |