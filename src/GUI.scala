import processing.core._
import java.awt.event.KeyEvent._
import java.io._
import scala.io.Source

class GUI extends PApplet{
  
  override def settings() = {
    this.size(Game.squareSize* 18,Game.squareSize* 18)
  }
  
  override def setup() = {
    frameRate = 60
    var data = ""
    for (line <- Source.fromFile("maps.txt").getLines()) // get info from savefile
      data = data + line + "\n"
    Load.loadGame(new StringReader(data))
  }
  
  override def draw() = {
    background(10)
    Player.updateCoords
    drawPlatforms
    drawPlayer
  }
  
  override def keyPressed() = {
     if(keyCode == VK_RIGHT)
       Player.moveRight = true
     if(keyCode == VK_LEFT)
       Player.moveLeft = true
     if(keyCode == VK_UP && Player.onGround)
       Player.jumpspeed = 17
  }
  
  override def keyReleased() = {
    if(keyCode == VK_RIGHT)
       Player.moveRight = false
     if(keyCode == VK_LEFT)
       Player.moveLeft = false
  }
  
  def drawPlayer = {
    fill(255)
    rect(Player.x, Player.y, Player.width, Player.height)
  }
  
  def drawPlatforms = {
    Game.platforms.foreach{p => {
      changeColor(p.r, p.g, p.b)
      rect(p.x, p.y, p.width, p.height)}
    }
  }
  
  def changeColor(r: Int, g: Int, b: Int) = {
    fill(r,g,b)
  }
  
}

object GUI {
	def main(args: Array[String]) {
		PApplet.main(Array[String]("GUI"))
	}
}	