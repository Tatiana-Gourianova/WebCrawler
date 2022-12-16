


function pause(){
    return new Promise(resolve => setTimeout(resolve, 3000))
}

let textFile = null

function createTextFile(text) {
    const data = new Blob([text], {type: 'text/plain'})

    if (textFile !== null)
        window.URL.revokeObjectURL(textFile)

    textFile = window.URL.createObjectURL(data)

    return textFile
}

function download(tagId, fileName) {
    let textToDownload = document.getElementById(tagId).value
    let a = document.createElement("a")
    a.href = createTextFile(textToDownload)
    a.download = fileName
    pause().then(() => {
        a.click()
    })
}