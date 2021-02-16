import java.time.LocalDateTime
import java.time.LocalDate


class Gigasecond(startDate: LocalDateTime) {
    constructor(startDate: LocalDate): this(startDate.atStartOfDay())

    val date: LocalDateTime = startDate.plusSeconds(GIGA_SEC)

    companion object {
        private const val GIGA_SEC = 1_000_000_000L
    }
}
