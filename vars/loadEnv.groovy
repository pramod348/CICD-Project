// vars/loadEnv.groovy
def call(String filePath = '.env') {
    def props = readFile(filePath).split('\n').collectEntries { line ->
        if (line.trim() && !line.startsWith('#')) {
            def parts = line.split('=', 2)
            if (parts.size() == 2) {
                [(parts[0].trim()): parts[1].trim()]
            } else {
                [:]
            }
        } else {
            [:]
        }
    }

    props.each { key, value ->
        if (key && value) {
            env[key] = value
        }
    }
}
