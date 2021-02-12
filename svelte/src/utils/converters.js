export function dateToString(date) {
    let day, month, year;

    month = '' + (date[1] + 1);
    day = '' + date[2];
    year = date[0];

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}