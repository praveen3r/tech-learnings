from person import Person
from game import Game

class Student(Person, Game):
  
  def __init__(self, fname, lname, game):
    super().__init__(fname,lname )
    Game.__init__(self, game )