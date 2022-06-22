const DateUtils = {

    parseDate(dateArray) {
        return new Date(dateArray[0], dateArray[1] - 1, dateArray[2],
            dateArray[3], dateArray[4], dateArray[5]);
    },

    composeDate(date) {
        return [date.getFullYear(), date.getMonth() + 1, date.getDate(),
            date.getHours(), date.getMinutes(), date.getSeconds()];
    },

    dateDiffText(date1, date2) {
        let hours = DateUtils.inHours(date1, date2);

        if(hours < 1) {
            return DateUtils.inMinutes(date1, date2) + " minutes";
        }

        if(hours > 24) {
            return DateUtils.inDays(date1, date2) + " days";
        }

        return hours + " hours";
    },

    inMinutes: function (d1, d2) {
        var t2 = d2.getTime();
        var t1 = d1.getTime();

        return parseInt((t2 - t1) / (60 * 1000));
    },

    inHours: function (d1, d2) {
        var t2 = d2.getTime();
        var t1 = d1.getTime();

        return parseInt((t2 - t1) / (3600 * 1000));
    },

    inDays: function (d1, d2) {
        var t2 = d2.getTime();
        var t1 = d1.getTime();

        return parseInt((t2 - t1) / (24 * 3600 * 1000));
    },

    inWeeks: function (d1, d2) {
        var t2 = d2.getTime();
        var t1 = d1.getTime();

        return parseInt((t2 - t1) / (24 * 3600 * 1000 * 7));
    },

    inMonths: function (d1, d2) {
        var d1Y = d1.getFullYear();
        var d2Y = d2.getFullYear();
        var d1M = d1.getMonth();
        var d2M = d2.getMonth();

        return (d2M + 12 * d2Y) - (d1M + 12 * d1Y);
    },

    inYears: function (d1, d2) {
        return d2.getFullYear() - d1.getFullYear();
    }
}

export default DateUtils;