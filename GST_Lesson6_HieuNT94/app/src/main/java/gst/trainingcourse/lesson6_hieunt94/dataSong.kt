package gst.trainingcourse.lesson6_hieunt94

data class dataSong(var nameSong : String, var nameAuthor : String, var sizeSong: Int)

data class authorList(var nameAuthor : String)

object Song{
    var song = listOf<dataSong>(
        dataSong("Tìm em", "Hồ Quang Hiếu", 1200),
        dataSong("Hãy trao cho anh", "Sơn Tùng MTP" , 2000),
        dataSong("Nơi tình yêu kết thúc", "Bùi Anh Tuấn", 1000),
        dataSong("Anh ơi ở lại", "Chi Pu", 1500),
        dataSong("Tìm em", "Hồ Quang Hiếu", 1200),
        dataSong("Hãy trao cho anh", "Sơn Tùng MTP" , 2000),
        dataSong("Nơi tình yêu kết thúc", "Bùi Anh Tuấn", 1000),
        dataSong("Anh ơi ở lại", "Chi Pu", 1500),
        dataSong("Tìm em", "Hồ Quang Hiếu", 1200),
        dataSong("Hãy trao cho anh", "Sơn Tùng MTP" , 2000),
        dataSong("Nơi tình yêu kết thúc", "Bùi Anh Tuấn", 1000),
        dataSong("Anh ơi ở lại", "Chi Pu", 1500),
        dataSong("Tìm em", "Hồ Quang Hiếu", 1200),
        dataSong("Hãy trao cho anh", "Sơn Tùng MTP" , 2000),
        dataSong("Nơi tình yêu kết thúc", "Bùi Anh Tuấn", 1000),
        dataSong("Anh ơi ở lại", "Chi Pu", 1500)
    )

}

object author{
    var author = listOf<authorList>(
        authorList("Chi Pu"),
        authorList("Bùi Anh Tuấn"),
        authorList("Hồ Ngọc Hà"),
        authorList("Sơn Tùng MTP"),
        authorList("Hồ Quang Hiếu")
    )
}