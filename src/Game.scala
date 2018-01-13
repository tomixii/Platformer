import scala.collection.mutable.Buffer

object Game {
  val squareSize = 35
  var gravity = 3
  var platforms = Buffer[Platform]()
  var ground = Buffer[Platform]()
  var rightWalls = Buffer[Platform](new Platform(Game.squareSize * 9, -Game.squareSize, Game.squareSize, Game.squareSize, 255, 0, 0))
  var leftWalls = Buffer[Platform](new Platform(Game.squareSize * 7, -Game.squareSize, Game.squareSize, Game.squareSize, 255, 0, 0))
  var walls = Buffer[Platform]()
}