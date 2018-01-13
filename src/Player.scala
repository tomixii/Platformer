

object Player {
  var x = 200
  var y = 60
  var width = 30
  var height = 30
  var speed = 3
  var moveRight = false
  var moveLeft = false
  var jumpspeed = 0
  var shoottimer = 0
//  var facingRight = true
  
  def onGround: Boolean = {
    Game.platforms.exists(p => p.y < this.y + this.height + Game.gravity && p.y > this.y &&
                         ((this.x > p.x && this.x < p.x + p.width) || 
                         (this.x + this.width > p.x && this.x + this.width < p.x + p.width)))
  }
  
  def hitRoof: (Boolean, Int) = {
    val platform = Game.platforms.find(p => p.y + p.height > this.y - this.jumpspeed && p.y < this.y &&
                                      ((this.x > p.x && this.x < p.x + p.width) || 
                                      (this.x + this.width > p.x && this.x + this.width < p.x + p.width)))
    if(platform.isDefined)
      (true, this.y - platform.get.y - platform.get.height)
    else
      (false,0)
  }

  def obstacleRight: Boolean = {
    Game.rightWalls.exists(p => p.x < this.x + this.width + this.speed && p.x > this.x&& 
                          ((this.y > p.y && this.y < p.y + p.height) || 
                          (this.y + this.height > p.y && this.y + this.height < p.y + p.height)))
  }
  
  def obstacleLeft: Boolean = {
    Game.leftWalls.exists(p => p.x + p.width > this.x - this.speed && p.x < this.x && 
                         ((this.y > p.y && this.y < p.y + p.height) ||
                         (this.y + this.height > p.y && this.y + this.height < p.y + p.height)))
    
  }
  
  
  def updateCoords = {
    println("x: " + x, "y: " + y)
    if(moveRight && !obstacleRight)
		  x += speed
    if(moveLeft && !obstacleLeft)
		  x -= speed
		if(!onGround)
		  y += Game.gravity
		if(y > 630)
		  y = -25  
		if(jumpspeed > 0) {
		  if(hitRoof._1){
			  jumpspeed = hitRoof._2
			  println(jumpspeed)
			  y -= jumpspeed 
		    jumpspeed = 0
		  }
		  else{
			  jumpspeed -= 1
			  y -= jumpspeed
		  }
		}
//		if(jumptimer != 0){
//		  if(hitRoof)
//		    jumptimer = 0
//		  else{
//			  y -= jump
//			  if (jumptimer > 0) jumptimer -= 1		  	    
//		  }
//		}
  }
}