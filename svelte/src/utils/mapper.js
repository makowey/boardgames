export function toSelectorItems(inputArray,
                                identifierName = "id",
                                displayName = "name",
                                displayFormat = "$ - $") {
    return inputArray.map(item => {
        return {
            value: item[identifierName],
            label: sprintf(displayFormat, item[identifierName], item[displayName])
        }
    });
}

// usage - console.log(sprintf("Success after $ clicks ($ seconds).", 15, 4.569)); sprintf.token = "$";
export const sprintf = (str, ...argv) => !argv.length ?
    str :
    sprintf(str = str.replace(sprintf.token || "$", argv.shift()), ...argv);