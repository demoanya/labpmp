package com.anna.demeshko.millionaire

/**
 * Created by mikemakhovyk on 07.04.2020.
 */
class Question(
    val description: String,
    var answers: List<Answer>
)

class Answer(
    val title: String,
    val isCorrect: Boolean
)

fun generateQuestions(): List<Question> {
    return listOf(
        Question(
            ("Збірна якої країни стала чемпіоном світу з футболу у 2002 році?"), listOf(
                Answer("Бразилія", true),
                Answer("Німеччина", false),
                Answer("Англія", false),
                Answer("Італія", false)
            )
        ),
        Question(
            ("Що з перерахованого нижче є найкращим провідником електричного струму?"), listOf(
                Answer("Срібло", true),
                Answer("Мідь", false),
                Answer("Сталь", false),
                Answer("Кераміка", false)
            )
        ),
        Question(
            ("Які комахи літають найшвидше?"), listOf(
                Answer("Бабки", true),
                Answer("Сарана", false),
                Answer("Комарі", false),
                Answer("Бджоли", false)
            )
        ),
        Question(
            ("Яка частина тіла може страждати від катаракти?"), listOf(
                Answer("Око", true),
                Answer("Голова", false),
                Answer("Шлунок", false),
                Answer("Нога", false)
            )
        ),
        Question(
            ("Що таке аспартам?"), listOf(
                Answer("Підсолоджувач", true),
                Answer("Добриво", false),
                Answer("Окислювач", false),
                Answer("Фарбник", false)
            )
        ),
        Question(
            ("Що означає, якщо на напої є напис 'zero'?"), listOf(
                Answer("Без цукру", true),
                Answer("Природний цукор", false),
                Answer("Більше цукру", false),
                Answer("Штучний цукор", false)
            )
        ),
        Question(
            ("Хто написав 'Війна і мир'?"), listOf(
                Answer("Л.М.Толстой", true),
                Answer("Т.Г.Шевченко", false),
                Answer("Ліна Костенко", false),
                Answer("І.Франко", false)
            )
        ),
        Question(
            ("Яке прізвисько у Тіріона Ланістера у серіалі 'Гра престолів'?"), listOf(
                Answer("Біс", true),
                Answer("Король за стіною", false),
                Answer("Клоун", false),
                Answer("Ворон", false)
            )
        ),
        Question(
            ("Собаки якої породи найменші?"), listOf(
                Answer("Чіхуахуа", true),
                Answer("Померанський шпіц", false),
                Answer("Доберман", false),
                Answer("Німецька вівчарка", false)
            )
        ),
        Question(
            ("Им'я першого космонавта?"), listOf(
                Answer("Ю.Гагарін", true),
                Answer("Л.Каденюк", false),
                Answer("Оззі Осборн", false),
                Answer("Віктор Ющенко", false)
            )
        ),
        Question(
            ("У якому році було проголошено незалежність України?"), listOf(
                Answer("1991", true),
                Answer("1994", false),
                Answer("1990", false),
                Answer("1997", false)
            )
        ),
        Question(
            ("Столиця Зімбабве?"), listOf(
                Answer("Хараре", true),
                Answer("Кампала", false),
                Answer("Лондон", false),
                Answer("Мельбурн", false)
            )
        ),
        Question(
            ("Як звати одного з персонажів мультсеріалу 'Фіксики'?"), listOf(
                Answer("Нолик", true),
                Answer("Валик", false),
                Answer("Бублик", false),
                Answer("Льолик", false)
            )
        ),
        Question(
            ("Кто Вероника по гороскопу?"), listOf(
                Answer("Овен", false),
                Answer("Кракозябра", true),
                Answer("Лев", false),
                Answer("Скорпион", false)
            )
        )
    )
}