#include <iostream>
#include <wiringPi.h>
#include <fstream>
#include <cmath>
#include <stdio.h>

#define PIN 0

//  g++  gipoController.c -l wiringPi -o  gipoController

void setup() {
	wiringPiSetup();
	pinMode(PIN, OUTPUT);
}


int main(void){
	int actual=LOW;
	setup();
	//init
	if(digitalRead(PIN) == LOW){
		actual=LOW;
	}else{
		actual=HIGH;
	}
	while(1){
		while(digitalRead(PIN)==actual);
		if(actual==LOW){
			actual=HIGH;
		}else{
			actual=LOW;
		}
		printf("%d\n",actual);
	}
	return 0;
	
	
}