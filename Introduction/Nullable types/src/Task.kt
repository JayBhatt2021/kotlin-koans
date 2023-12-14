fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    if (client?.personalInfo?.email == null || message == null) {
        return;
    }
    return mailer.sendMessage(client.personalInfo.email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
