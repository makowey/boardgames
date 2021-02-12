function emailValidator() {
    return function email(value) {
        return (value && !!value.match(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) || 'Please enter a valid email'
    }
}

function requiredValidator(isRequired, fieldname, errorText) {
    return function required(value) {
        return (!isRequired || (value !== undefined && value !== null && value !== '')) || errorText ||
            'The [' + fieldname.toUpperCase() + '] field is required'
    }
}

export {
    emailValidator,
    requiredValidator
}
