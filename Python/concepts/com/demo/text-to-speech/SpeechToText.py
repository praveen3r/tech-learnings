import speech_recognition as sr

# Initialize recognizer
recognizer = sr.Recognizer()

# Use the microphone for input
# with sr.Microphone() as source:
with sr.AudioFile('output.mp3') as source:
    print("Adjusting for ambient noise. Please wait...")
    recognizer.adjust_for_ambient_noise(source, duration=2)
    print("Listening for your speech...")
    
    try:
        # Record the audio
        audio = recognizer.listen(source, timeout=5)
        print("Recognizing speech...")
        
        # Convert speech to text using Google's API
        text = recognizer.recognize_google(audio)
        print("You said:", text)
    except sr.UnknownValueError:
        print("Sorry, I could not understand the audio.")
    except sr.RequestError as e:
        print(f"Could not request results; {e}")
    except Exception as ex:
        print(f"An error occurred: {ex}")