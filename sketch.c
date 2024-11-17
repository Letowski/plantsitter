#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
#define WIFI_SSID "your-wifi-ssid"
#define WIFI_PASS "your-wifi-pass"
#define HTTP_REST_PORT 8080
#define RELAY1_PIN 5 //D1

ESP8266WebServer server(HTTP_REST_PORT);

void setup() {
  Serial.begin(115200);
  WiFi.begin(WIFI_SSID, WIFI_PASS);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("Connected");
  Serial.println(WiFi.localIP());

  pinMode(RELAY1_PIN, OUTPUT);

  restServerRouting();
  server.begin();
  Serial.println("HTTP server started");
}

void loop() {
  server.handleClient();
}

void restServerRouting() {
    server.on("/", HTTP_GET, []() {
        server.send(200, F("text/html"),
            F("Welcome to the REST Web Server"));
    });
    server.on(F("/relay1on"), HTTP_GET, relay1on);
    server.on(F("/relay1off"), HTTP_GET, relay1off);
}

void relay1on() {
  server.send(200, F("text/html"), F("relay1on"));
  digitalWrite(RELAY1_PIN, HIGH);
}

void relay1off() {
  server.send(200, F("text/html"), F("relay1off"));
  digitalWrite(RELAY1_PIN, LOW);
}
