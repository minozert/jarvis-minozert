import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(2,GPIO.OUT)
GPIO.setup(3,GPIO.OUT)
GPIO.setup(4,GPIO.OUT)

GPIO.output(2, GPIO.HIGH)
GPIO.output(3, GPIO.HIGH)
GPIO.output(4, GPIO.HIGH)

