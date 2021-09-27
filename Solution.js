
/**
 * @param {string[]} emails
 * @return {number}
 */
var numUniqueEmails = function (emails) {

    const uniqueEmails = new Set();
    let n = emails.length;

    for (let i = 0; i < n; i++) {

        let i_ATsign = emails[i].indexOf('@');
        let i_FirstPlus = emails[i].indexOf('+');
        let i_FirstPart = i_FirstPlus > -1 ? i_FirstPlus : i_ATsign;

        uniqueEmails.add(clearEmail(emails[i], i_FirstPart, i_ATsign));
    }

    return uniqueEmails.size;
};

/*
 Both 'indexFirstPart',  'indexATsign' are arguments for the method, since 
 they might the different, depending on whether substring(0, indexOf('@')) 
 the contains the character '+'.
 
 To reconstruct the cleared eamil without encumbering 'if-else' statements,
 we need both indexes.
 */
/**
 * @param {string} email => email to be cleared
 * @param {string} indexFirstPart => index of first '+'. If there is no '+', then index  of '@'
 * @param {string} indexATsign => index  of '@'
 * @return {string}cleared email, as per the problem statement
 */
function clearEmail(email, indexFirstPart, indexATsign) {
    return email.substr(0, indexFirstPart).replace(/\./g, '') + email.substr(indexATsign, email.length);
}
