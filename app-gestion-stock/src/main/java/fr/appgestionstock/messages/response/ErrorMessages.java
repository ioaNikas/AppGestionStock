package fr.appgestionstock.messages.response;

public enum ErrorMessages {

	MISSING_REQUIRED_FIELD("Un champ requis est manquant. Veuillez consulter la documentation pour les champs requis."),
	RECORD_ALREADY_EXISTS("Cet objet existe déjà dans la base de donnée."),
	INTERNAL_SERVER_ERROR("Erreur interne du serveur."),
	NO_RECORD_FOUND("L'objet avec l'id renseigné n'a pas été trouvé."),
	AUTHENTICATION_FAILED("L'authentification a raté."), COULD_NOT_UPDATE_RECORD("L'objet n'a pas pu être mis à jour."),
	COULD_NOT_DELETE_RECORD("L'objet n'a pas pu être supprimé."),
	EMAIL_ADDRESS_NOT_VERIFIED("L'email n'a pas pu être vérifié.");

	private String errorMessage;

	ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
