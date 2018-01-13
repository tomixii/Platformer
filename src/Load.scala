import java.io.BufferedReader
import java.io.IOException
import java.io.Reader
import scala.collection.mutable.Buffer

object Load {
  
  def loadGame(input: Reader) = {
    val lineReader = new BufferedReader(input)
    var currentLine = lineReader.readLine()
    var text = Buffer[String]() //file in bufferform
    var line = 0 //starting line
    var fileRead = false
    
    while (currentLine != null) { //adds all the lines to buffer
      text += currentLine
      currentLine = lineReader.readLine()
    }
    
    while (line < text.size) {
      for(i <- 0 until text(line).size){
    	  if(text(line)(i) != 'A'){
    	    val platform = new Platform(Game.squareSize*i, Game.squareSize*line, Game.squareSize, Game.squareSize, 255, 0, 0)
    	    Game.platforms += platform
    	    if(text(line)(i) == 'G')
    	      Game.ground += platform
    	    else if(text(line)(i) == 'R')
    	      Game.rightWalls += platform
    	    else if(text(line)(i) == 'L')
    	      Game.leftWalls += platform
    	    else if(text(line)(i) == 'W'){
    	      Game.rightWalls += platform
    	      Game.leftWalls += platform
    	    }
    	  }
      }
      line += 1
          
    }
  }
}