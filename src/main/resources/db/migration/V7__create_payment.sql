--
-- Structure de la table `payment`
--

CREATE TABLE `payment` (
                           `id` bigint(20) NOT NULL,
                           `payment_date` datetime DEFAULT NULL,
                           `payment_mode` varchar(255) DEFAULT NULL,
                           `invoice_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `payment`
--
ALTER TABLE `payment`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKsb24p8f52refbb80qwp4gem9n` (`invoice_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `payment`
--
ALTER TABLE `payment`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;