package uniandes.algorithms.coinchange;

public class AlgoritmoProgramacionDinamica implements CoinChangeAlgorithm {

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int[][] matrizCambio = new int[denominations.length + 1][totalValue + 1];

		for (int i = 0; i < denominations.length; i++)
			matrizCambio[i][0] = 0;

		for (int j = 1; j <= totalValue; j++)
			matrizCambio[0][j] = 99;

		for (int i = 1; i <= denominations.length; i++) 
		{
			for (int j = 1; j <= totalValue; j++) {
				if (j < denominations[i - 1]) {
					matrizCambio[i][j] = matrizCambio[i - 1][j];
				} else {
					int minimo = 0;
					minimo = Math.min(matrizCambio[i - 1][j] , matrizCambio[i][j- denominations[i - 1]] + 1);
					matrizCambio[i][j] = minimo;
				}
			}
		}


		int i,j;
		int[] seleccion = new int[denominations.length];
		for(i = 0; i< denominations.length; i++)
		{seleccion[i]=0;} 


		i= denominations.length;
		j= totalValue;
		while(j>0)
		{
			if(i>1 && matrizCambio[i][j]==matrizCambio[i-1][j]){
				i--;
			}
			else{
				seleccion[i-1]++;
				j = j - denominations[i-1];
			}
		}

		return seleccion;
	}
}
