const exceptions = ["windengineID", "timestamp"]
const formaters = {
    timestamp: (time) => new Date(time).toLocaleString(),
}

const engineList = []

function addEngine(id) {
    if(engineList.includes(id)) return

    engineList.push(id)
    const template = `
    <div class="engine">
        <h1>ID: <span id="windengineID-${id}"></span></h1>
        <h3>Time: <span id="timestamp-${id}"></span></h3>

        <table id="table-${id}">
            <tr>
                <th>Attribute</th>
                <th>Value</th>
            </tr>
        </table>
    </div>`
    $('#engineList').append(template)
}

function fillData(data) {
    const id = data.windengineID
    addEngine(id)

    for (let key in formaters) {
        if (data[key]) {
            data[key] = formaters[key](data[key])
        }
    }

    const table = $(`#table-${id}`)

    let units = {}

    table.empty()

    for (i in data) {
        if (exceptions.includes(i)) {
            $(`#${i}-${id}`).text(data[i])
        } else if (i.startsWith("unit")) {
            units[i.replace("unit", "").toLowerCase()] = data[i]
        } else {
            table.append(`<tr><td>${i}</td><td id="${i}-${id}">${data[i]}</td></tr>`)
        }
    }

    for (i in units) {
        $(`#${i}-${id}`).append(" " + units[i])
    }
}

async function fetchEngines() {
    const engines = (await $.getJSON("/windengine/data/json")).windengine

    for(let engine of engines) {
        fillData(engine);
    }
}

$(document).ready(function () {
    fetchEngines()
        .then(() => setInterval(fetchEngines, 100))
        .catch(error => console.error(error))
})