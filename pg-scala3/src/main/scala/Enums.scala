object Enums {

    enum Permissions {
        case READ, WRITE, EXEC, NONE
    }

    /*
        sealed class Permissions
        + READ, WRITE, EXEC, NONE
    */
    val read = Permissions.READ

    enum PermissionsWithBits(val bits: Int){
        case READ extends PermissionsWithBits(4)
        case WRITE extends PermissionsWithBits(2)
        case EXEC extends PermissionsWithBits(1)
        case NONE extends PermissionsWithBits(0)

        def toHex: String = Integer.toHexString(bits)
    }
    val read2 = PermissionsWithBits.READ
    val bitString = read2.bits
    val hexString = read2.toHex

    object PermissionsWithBits{
        def fromBits(bits: Int): PermissionsWithBits =
            PermissionsWithBits.READ
    }

    val first = Permissions.READ.ordinal
    val allPermissions = Permissions.values // array with all possible values

    val readPersmission: Permissions = Permissions.valueOf("READ")
    val readPersmission2: PermissionsWithBits = PermissionsWithBits.valueOf("READ")

    println(s"readPersmission2 $readPersmission2")


    def main(args: Array[String]): Unit = {
        println(read)
    }

}
