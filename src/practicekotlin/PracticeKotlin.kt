package practicekotlin

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Calendar
import java.util.Date
import java.util.Random
import kotlin.math.sqrt

fun main() {
println(divideOrSquare(12))
    convertAdd(listOf("1", "2", "5"))
    println(registerCheck(mapOf("Michael" to "yes", "John" to "no",
        "Peter" to "yes", "Mary" to "yes"
    )))

    println("Floats ${onlyFloats(2, 2.8f)}")

   // calculatePriceAfterDiscount()
  //  userNameGenerator()
   // stringRange(6)
   // oddEven(listOf(1,2,4,6))
   // biggestOdd("23589")
    //hideMyPassword()
  //  println(equalStrings("lovee", "eveol"))
  //  countDots("h.e.l.p")
   // yourAge()
   // payYourTax()
//    flatten_list(listOf(listOf(1,2,3,4)))
//    salaryCalculator()
//    println(same_in_reverse("drew"))
//    sumTheList(listOf(listOf(1, 8, 10, 2), listOf(3,5,7,9)))
//    usernameGenerator()
//    anyNumberOfArguments(12,10,2,3,8)
    countWords("I love learning")
    countElements("I love learning")
    capitalizeFirstLetter("i love learning")
    makeLists(listOf(1, 2, 3, 4), listOf(5, 6, 7, 8))
}

//DAY 1
/**
 * Write a function called divide_or_square that takes one argument (a number),
 * and returns the square root of the number if it is divisible by 5, returns its
 * remainder if it is not divisible by 5. For example, if you pass 10 as an argument,
 * then your function should return 3.16 as the square root.
 */
fun divideOrSquare(numb: Int): Double {
    val toDouble = numb.toDouble()
    return if (toDouble % 5 == 0.0) {
        sqrt(toDouble)
    } else {
        toDouble % 5
    }
}
//DAY 2
/**
 * Write a function called convert_add that takes a list of strings as an argument
 * and converts it to integers and sums the list. For example [‘1’, ‘3’, ‘5’] should
 * be converted to [1, 3, 5] and summed to 9.
 */
fun convertAdd(myList: List<String>) {
   val convertList = mutableListOf<Int>()
     myList.forEach {
         if (it.toIntOrNull() != null) {
             convertList.add(it.toInt())
         }
     }
    println(convertList.sum().toString())
     myList.onEach {
         it.toIntOrNull()
     }
}

//DAY 3
/**
 * Write a function called register_check that checks how many students are in school.
 * The function takes a dictionary as a parameter. If the student is in school,
 * the dictionary says ‘yes’. If the student is not in school, the dictionary says ‘no’.
 * Your function should return the number of students in school. Use the dictionary below.
 * Your function should return 3.
 */
fun registerCheck(register: Map<String, String>): Int {
   return register.filter {
        it.value == "yes"
    }.size
}

//DAY 4
/**
 * Write a function called only_floats, which takes two parameters a and b,
 * and returns 2 if both arguments are floats, returns 1 if only one argument is a float,
 * and returns 0 if neither argument is a float. If you pass (12.1, 23) as an argument,
 * your function should return a 1.
 */
fun onlyFloats(a: Any, b: Any): Int {
    return if (a is Float && b is Float ) {
        2
    } else if (a is Float || b is Float) {
        1
    } else {
       0
    }
}

//DAY 5
/**
 * Create a function called my_discount. The function takes no arguments but asks the user
 * to input the price and the discount (percentage) of the product. Once the user inputs the
 * price and discount, it calculates the price after the discount. The function should return
 * the price after the discount. For example, if the user enters 150 as price and 15% as the discount,
 * your function should return 127.5.
 */
fun calculatePriceAfterDiscount() {
    println("Enter price: ")
    val enterPrice = readlnOrNull()?.toDouble()

    println("Enter percentage discount:")
    val enterDiscount = readlnOrNull()?.toDouble()
    val discountPercentage = enterDiscount?.div(100.00)
    val discount = discountPercentage?.let { enterPrice?.times(it) }

    println("$enterPrice - $discount = ${discount?.let { enterPrice?.minus(it) }}")
}

//DAY 6
/**
 * Write a function called user_name that generates a username from the user’s email.
 * The code should ask the user to input an email and the code should return everything
 * before the @ sign as their username. For example, if someone enters ben@gmail.com,
 * the code should return ben as their username.
 */
fun userNameGenerator() {
    println("Enter your email:")
    val email = readln()
    val username = email.split("@")[0]
    println("Your username is $username")
}

//DAY 7
/**
 * Write a function called string_range that takes a single number and
 * returns a string of its range. The string characters should be separated by dots(.)
 * For example, if you pass 6 as an argument, your function should return ‘0.1.2.3.4.5’.
 */
fun stringRange(num: Int) {
    val range = 0 until num
    println(range.joinToString("."))
}

//DAY 8
/**
 * Write a function called odd_even that has one parameter and
 * takes a list of numbers as a parameter. The function returns
 * the difference between the largest even number in the list and
 * the smallest odd number in the list. For example, if you pass [1,2,4,6]
 * as an argument the function should return 6 -1= 5.
 */
fun oddEven(nums: List<Int>) {
    val maxEven = nums.filter { it % 2 == 0 }.max()
    val minOdd = nums.filter { it % 2 == 1 }.min()

    println("$maxEven - $minOdd = ${maxEven-minOdd}")
}

//DAY 9
/**
 * Create a function called biggest_odd that takes a string of numbers
 * and returns the biggest odd number in the list.
 * For example, if you pass ‘23569’ as an argument,
 * your function should return 9. Use list comprehension.
 */
fun biggestOdd(numbs: String) {
   val maxOdd = numbs.map { it.toString().toInt() }.filter { it % 2 == 1 }.max()
    println("The biggest odd number from $numbs is $maxOdd")
}

// DAY 10
/**
 * Write a function called hide_password that takes no arguments.
 * The function takes an input( a password) from a user and returns a hidden password.
 * For example, if the user enters ‘hello’ as a password the function should return ‘****’
 * as a password and tell the user that the password is 4 characters long.
 */
fun hideMyPassword() {
    print("Enter your password:")
    val password = readln()
    var hide = String()
    repeat(password.length) {
        hide += "*"
    }
    println("Your password $hide is ${password.length} characters long.")
}

//DAY 11
/**
 *
Write a function called equal_strings. The function takes two strings as arguments
and compares them. If the strings are equal (if they have the same characters and
have equal length), it should return True, if they are not, it should return False.
For example, ‘love’ and ‘evol’ should return True.
 */
fun equalStrings(string1: String, string2: String) : Boolean {
    val a = string1.toCharArray().sortedArray()
    val b = string2.toCharArray().sortedArray()
    println(a)
    println(b)
    return a.contentEquals(b)
}

//DAY 12
/**
 * Write a function called count_dots. This function takes a string separated by dots
 * as a parameter and counts how many dots are in the string. For example, ‘h.e.l.p.’
 * should return 4 dots, and ‘he.lp.’ should return 2 dots.
 */
fun countDots(dots: String?) {
    val dotLength: Int = dots?.count { it.toString() == "." } ?: 0
    println("$dotLength dots")
}

//DAY 12 EXTRA CHALLENGE
fun yourAge() {
    var birthYear: String
    var isYearValid = false

    while (!isYearValid){
        print("Please enter a valid year of birth: ")
        birthYear = readln()
        val validYear = birthYear.toInt()
        if (validYear > 1900 && validYear <= LocalDate.now().year && validYear.toString().length == 4) {
            isYearValid = true
            val age = LocalDate.now().year - validYear
            val ageInMinutes = age * 365 * 24 * 60
            println("Your are $ageInMinutes minutes old.")
        } else {
            isYearValid = false
        }
    }
}

//DAY 13
/**
 * Write a function called your_vat. The function takes no parameter.
 * The function asks the user to input the price of an item and VAT (vat should be a percentage).
 * The function should return the price of the item plus VAT. If the price is 220 and,
 * VAT is 15% your code should return a vat inclusive price of 253. Make sure that your code can handle ValueError.
 * Ensure the code runs until valid numbers are entered. (hint: Your code should include a while loop).
 */
fun payYourTax() {
    var isValueValid = false

    while (!isValueValid) {
        print("What is the price of the item? ")
        val price = readln()
        val priceToInt = price.toDoubleOrNull()
        print("What is the VAT? ")
        val vat = readln()
        val vatToDouble = vat.toDoubleOrNull()

        if (priceToInt is Double && vatToDouble is Double ) {
            isValueValid = true
            val princeInclusiveVat = priceToInt + (priceToInt * vatToDouble/100)
            println("The total price inclusive of VAT is $$princeInclusiveVat")
        } else {
            isValueValid = false
            println("Please enter valid values")
        }
    }
}
/**
 * Day 14: Flatten the List
 *Write a function called flat_list that takes one argument, a nested list.
 * The function converts the nested list into a one-dimension list.
 * For example [[2,4,5,6]] should return [2,4,5,6].
 */

fun flatten_list(list: List<List<Any>>) {
    val flattenList = list.flatten()
    println("Original list: ${list.toString()}")
    println("Flattened list: ${flattenList.toString()}")
}
/**
 * Extra Challenge: Teacher’s Salary
 *
 * A school has asked you to write a program that will calculate teachers' salaries.
 * The program should ask the user to enter the teacher’s name,
 * the number of periods taught in a month, and the rate per period.
 * The monthly salary is calculated by multiplying the number of periods by the monthly rate.
 * The current monthly rate per period is $20. If a teacher has more than 100 periods in a month,
 * everything above 100 is overtime. Overtime is $25 per period.
 * For example, if a teacher has taught 105 periods, their monthly gross salary should be 2,125.
 * Write a function called your_salary that calculates a teacher’s gross salary.
 * The function should return the teacher’s name, periods taught, and gross salary.
 * Here is how you should format your output:
 *
 * Teacher: John Kelly,
 * Periods: 105
 * Gross salary:2,125
 */
data class Teacher(
    val name: String,
    val periods: Int,
    val normalRatePerPeriod:Double = 20.00,
    val overtimeRateAboveNormalPerPeriod: Double = if (periods > 100) 5.0 else 0.0,
    var grossSalary: Double = 0.0
) {

    fun monthlySalary(): Double {
            return if (periods <= 100) {
                periods * normalRatePerPeriod
            } else {
                (periods * normalRatePerPeriod) + ((periods - 100) * overtimeRateAboveNormalPerPeriod)
            }
    }
}

fun salaryCalculator() {
    print("Please enter your name: ")
    val name = readlnOrNull()
    print("How many periods have you taught this month? ")
    val periods = readlnOrNull()?.toInt()

    val teacher = periods?.let { Teacher(name = "Teacher: $name", periods = it) }
    teacher?.grossSalary = teacher?.monthlySalary()!!
    println(teacher)
    }

/**
 * DAY 15 SAME IN REVERSE
 * Write a function called same_in_reverse that takes a string and checks if the string reads the same in reverse.
 * If it is the same, the code should return True if not, it should return False.
 * For example, ‘dad’ should return True, because it reads the same in reverse.
 */
fun same_in_reverse(string: String) : Boolean {
    return string == string.reversed()
}

/**
 * DAY 16 - Sum the list
 * Write a function called sum_list that takes a nested list of integers as an argument
 * and returns the sum of the integers. For example, if you pass [[2, 4, 5, 6], [2, 3, 5, 6]]
 * your function should return a sum of 33.
 */
fun sumTheList(list: List<List<Int>>) {
    val sum = list.flatten().sum()
    println("Sum of the list is $sum")
}

/**
 * DAY 17 Username Generator
 * Write a function called user_name, that creates a username for the user.
 * The function should ask a user to input their name.
 * The function should then reverse the name and attach a randomly issued number between 0 – 9 at the end of the name.
 * The function should return the username.
 */
fun usernameGenerator() {
    print("Please enter your name:")
    val name = readlnOrNull()
    val randomNumber = (0..9).random()
    val username = "${name.toString().reversed()}${randomNumber.toString()}"
    println("Your username is $username")
}

/**
 * DAY 18 - Any number of arguments
 * Write a function called any_number that can receive any number of arguments(integers and floats)
 * and return the average of those integers. If you pass 12, 90, 12, 34 as arguments your function
 * should return 37.0 as average. If you pass 12, 90 your function should return 51.0 as average.
 */
fun anyNumberOfArguments(vararg ints: Int) {
    val average = ints.average()
    println("The average of the numbers ${ints.asList()} is $average")
}

/**
 * Day 19 - Words and Elements
 * Write two functions. The first function is called count_words which takes a string of words and
 * counts how many words are in the string.
 *
 * The second function called count_elements takes a string of words and counts how many elements are in the string.
 * Do not count the whitespaces. The first function will return the number of words in a string and the second one
 * will return the number of elements less whitespace. If you pass ‘I love learning’, the count_words function
 * should return 3 words and count_elements should return 13 elements.
 */
fun countWords(words: String) {
    val length = words.split(" ").size
    println("The string has $length words.")
}

fun countElements(words: String) {
    val length = words.replace(" ", "").length
    println("The string has $length elements")
}

/**
 * Day 20 - Capitalize First Letter
 * Write a function called capitalize.
 * This function takes a string as an argument and capitalizes the first letter of each word.
 * For example, ‘i like learning’ becomes ‘I Like Learning’.
 */
fun capitalizeFirstLetter(word: String) {
    val capitalized = word.split(" ").joinToString(" "){ it.replaceFirstChar { it.uppercase() } }
    println(capitalized)
}

/**
 * Day 21: List of Tuples
 *
 * Write a function called make_tuples that takes two lists, equal lists, and combines
 * them into a list of tuples. For example if list a is [1,2,3,4] and list b is [5,6,7,8],
 * your function should return [(1,5),(2,6),(3,7),(4,8)].
 */
fun makeLists(listOne: List<Any>, listTwo: List<Any>) {
    val list: MutableList<List<Any>> = mutableListOf()
    if (listOne.size == listTwo.size) {
        repeat(listOne.size) {
            list.add(mutableListOf(listOne[it], listTwo[it]))
        }
    }
    println("Combined List: $list")
}