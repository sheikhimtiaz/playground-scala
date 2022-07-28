object Enums {

    enum Permissions {
        case READ, WRITE, EXEC, NONE
    }

    val read = Permissions.READ

    def main(args: Array[String]): Unit = {
        println(read)
    }

}
