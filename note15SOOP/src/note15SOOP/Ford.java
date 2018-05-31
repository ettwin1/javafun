package note15SOOP;

public interface Ford {
	enum ModelNames {
		FOCUS, FUSION, MUSTANG, F150
	};
	public boolean onStarTest(Ford.ModelNames model);
}
